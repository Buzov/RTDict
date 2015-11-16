/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capcha;

import com.github.cage.Cage;
import com.github.cage.GCage;
import com.github.cage.YCage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author artur
 */
public class App {
  public static void main(String[] args) throws IOException {
    generate(new GCage(), 2, "cg1", ".jpg", "colding");
    generate(new YCage(), 2, "cy1", ".jpg", "eT6wLAH");
    generate(new GCage(), 2, "cg2", ".jpg", null);
    generate(new YCage(), 2, "cy2", ".jpg", null);
  }

  protected static void generate(Cage cage, int num, String namePrefix,
      String namePostfix, String text) throws IOException {
    for (int fi = 0; fi < num; fi++) {
      OutputStream os = new FileOutputStream(namePrefix + fi
          + namePostfix, false);
      try {
        cage.draw(
            text != null ? text : cage.getTokenGenerator().next(),
            os);
      } finally {
        os.close();
      }
    }
  }
}
