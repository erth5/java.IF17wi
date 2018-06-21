import javafx.application.Application; 
import javafx.scene.Scene;
import javafx.stage.Stage; 
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javafx.geometry.Point2D;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Button;

public class MausDemo  extends Application
{     
    private Point2D lastPos, currPos;
    private Color paintColor = Color.BLACK;

    public void setCurrPos(MouseEvent e)
    {
        currPos = new Point2D( e.getX(), e.getY() );
    }

    public void newCurrPos(MouseEvent e)
    {
        lastPos = currPos;
        currPos = new Point2D( e.getX(), e.getY() );
    }

    public void paintLine(GraphicsContext gc)
    {
        gc.setStroke( paintColor );
        gc.strokeLine( lastPos.getX(), lastPos.getY(), currPos.getX(), currPos.getY() );
    }

    public void clearPicture(GraphicsContext gc, Canvas c)
    {
        gc.clearRect(0,0, c.getWidth(), c.getHeight() );
    }

    public static void main(String[] args)
    {        
        Application.launch(args);
    }
    
    public void start(Stage primaryStage) 
    {          
        //stage = fenster
        primaryStage.setTitle("Maus Demo"); 
        primaryStage.setResizable(false);
            
        //Vbox = container mit verticalem layout
        VBox root = new VBox();
            
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        canvas.setOnMousePressed( e -> { setCurrPos(e); } );

        //gc muss nicht gecaptured werden, weil es eine bereits existente Variable ist
        canvas.setOnMouseDragged( e -> { newCurrPos(e); paintLine(gc); } );

        //canvas zur VBox hinzufuegen
        root.getChildren().add( canvas );

        HBox buttonBox = new HBox();

        root.getChildren().add(buttonBox);

        ColorPicker cp = new ColorPicker();
        cp.setOnAction( t -> { paintColor = cp.getValue(); } );

        Button btnClear = new Button( "CLEAR" );
        btnClear.setOnAction( t -> { clearPicture(gc, canvas); } );

        buttonBox.getChildren().add(cp);
        buttonBox.getChildren().add(btnClear);

        //fenster inhalt
        Scene scene = new Scene(root );     

        primaryStage.setScene(scene); 
        primaryStage.show(); 
    } 
}
