package com.kaminsky;

public class App
{
   public static void main(String args[]) {
      MyStringBuilder myStringBuilder = new MyStringBuilder("Строка");
      myStringBuilder.append("еще строка");
      myStringBuilder.append("ещеоднастрока");
      myStringBuilder.undo();
      String result = myStringBuilder.toString();

      System.out.println(result);

   }
}
