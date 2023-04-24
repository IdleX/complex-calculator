/*
 * Copyright 2023 Complex calculator
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package utils;

import javax.swing.*;
import javax.swing.text.*;
import java.util.regex.Pattern;

public class DoubleTextField extends JTextField {

  public DoubleTextField() {
    super();
    setColumns(10);
    ((AbstractDocument) getDocument()).setDocumentFilter(new DoubleFilter());
  }

  private static class DoubleFilter extends DocumentFilter {
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("-?\\d*\\.?\\d*");

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
        throws BadLocationException {
      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.replace(offset, offset + length, text);
      if (test(sb.toString())) {
        super.replace(fb, offset, length, text, attrs);
      }
    }

    private boolean test(String text) {
      return DOUBLE_PATTERN.matcher(text).matches();
    }
  }
}