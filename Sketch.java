import processing.core.PApplet;

public class Sketch extends PApplet {
	
  float[] circleY = new float[100];
  float[] rectHeights = new float[100];
  float rectHeight = 5;
  int num = 25;
  int[] x = new int[num];
  int[] y = new int[num];

  public void settings() {

    size(400, 400);
  }

  public void setup() {
    background(0);

    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
    }

  }

  public void draw() {

    background(0);

    fill(225);
    stroke(225);

    for(int j = 0; j < 100; j++){
      rect(j * 4, 400, 4, rectHeights[j] * - 1);
    }

    for (int i = 0; i < circleY.length; i++) {
      float circleX = width * i / circleY.length;
      ellipse(circleX, circleY[i], 5, 5);

      if (keyCode == UP) {
        circleY[i]+=3;
      } else if (keyCode == DOWN) {
        circleY[i]++;
      } else {
        circleY[i]+=2;
      }

      if (circleY[i] > height) {
        circleY[i] = 0;
        rectHeights[i] += 1;
      }
    }

    for (int i = 0; i < num-1; i++) {
      x[i] = x[i+1];
      y[i] = y[i+1];
    }

    x[24] = mouseX;
    y[24] = mouseY;

    for (int i = 0; i < num; i++) {
      ellipse(x[i], y[i], i/2, i/2);
    }

    }

  }
  
