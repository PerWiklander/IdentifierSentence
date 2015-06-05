package biz.wiklander.tools;

import java.util.Arrays;

public class ListCleaner {
  public static void main(final String[] args) {
//    formatList(args, 5);
    String[] a = Arrays.asList(
        "",
        ""
    ).toArray(new String[0]);

    formatList(a, 5);
  }

  public static void formatList(
      final String[] words,
      final int wordsPerLine
  ) {

    Arrays.sort(words);

    final int[] charCount = new int[wordsPerLine];

    int i = 0;
    for (final String word : words) {
      if (!(charCount[i % wordsPerLine] > word.length())) {
        charCount[i % wordsPerLine] = word.length();
      }

      i++;
    }

    i = 0;
    for (final String word : words) {
      if (i % wordsPerLine == 0) {
        System.out.print("\n");
      }

      System.out.print(String.format("%1$-"
          + (charCount[i % wordsPerLine] + 4)
          + "s", "\"" + word + "\", "));

      i++;
    }
  }
}
