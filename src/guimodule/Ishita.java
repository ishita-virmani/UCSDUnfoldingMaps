package guimodule;

import processing.core.*;

public class Ishita extends PApplet {
	PImage webImg;

	// configure the canvas
	// Executed once
	public void setup() {
		String url = "https://processing.org/img/processing-web.png";
		size(400, 400);
		webImg = loadImage("/home/ishitavirmani/Desktop/me.jpeg");
		//resize the image to width decided by Java and height of canvas itself (dynamic, will change on resizing of canvas)
		webImg.resize(0, height);
	}

	// display content
	// Loops often - like on zooming in/ resizing
	public void draw() {
		background(0);
		//to display the above loaded image
		image(webImg, 0, 0);
		
		//fill the circle with yellow color
		fill(255, 209, 0);
		//create a circle like sun
		ellipse(width / 4, height / 5, width / 5, height / 5);
	}
}
