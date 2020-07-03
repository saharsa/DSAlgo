package UpGrad.StackQueueAssignment;

import java.util.Stack;

public class SolutionA {

  private static Stack<String> history = new Stack<>();

  /**
   * Returns true if browsing history is empty, else false. Uses in-built method of Stack class:
   * isEmpty(). Time complexity: O(1).
   *
   * @return boolean value
   */
  public static Boolean isBrowsingHistoryEmpty() {
    // Add CODE BELOW
    return history.isEmpty();
  }

  /**
   * Returns the url of the most recently visited site. If browsing history is empty, then returns
   * an appropriate error message. (Would have preferred to return an empty string here, but in one
   * of the discussion forum answers TA has mentioned to display the below message) The default
   * behaviour of peek is to throw EmptyStackException when size of stack is 0. To avoid getting
   * exceptions, as error handling is not done in main, empty check added before peeking. Time
   * complexity: O(1).
   *
   * @return url of the recently visited site
   */
  public static String mostRecentlyVisitedSite() {
    // Add CODE BELOW
    return isBrowsingHistoryEmpty() ? "Browsing history is empty" : history.peek();
  }

  /**
   * Adds a website url to the browsing history. If null, then doesn't add. Time complexity: O(1).
   *
   * @param url website url to be added
   */
  public static void addSiteToHistory(String url) {
    // Add CODE BELOW
    if (url != null) {
      history.add(url);
    }
  }

  /**
   * Removes n items from the browsing history as long as browsing history isn't empty. If empty,
   * then does nothing. Time complexity: O(n).
   *
   * @param n no. of items to be removed from browsing history
   */
  public static void goBackInTime(int n) {
    // Add CODE BELOW
    int i = 1;
    while (i <= n && !isBrowsingHistoryEmpty()) {
      history.pop();
      i++;
    }
  }

  /**
   * Prints the browsing history to the console. If browsing history is empty, then prints
   * appropriate message. Relying on the toString() method of AbstractCollection.java to display the
   * stack items. Time complexity: O(n).
   */
  public static void printBrowsingHistory() {
    // Add CODE BELOW
    if (isBrowsingHistoryEmpty()) {
      System.out.println("Browsing history is empty");
    } else {
      System.out.println(history);
    }
  }

  public static void main(String[] args) {
    System.out.println(isBrowsingHistoryEmpty()); // Checking if Browsing History is Empty
    addSiteToHistory("www.google.co.in"); // Navigating to Google
    addSiteToHistory("www.facebook.com"); // Navigating to Facebook
    addSiteToHistory("www.upgrad.com"); // Navigating to UpGrad
    System.out.println(isBrowsingHistoryEmpty()); // Checking if Browsing History is Empty
    System.out.println(mostRecentlyVisitedSite()); // Fetching most recently visited site (UpGrad)
    addSiteToHistory("www.youtube.com"); // Navigating to Youtube
    goBackInTime(2); // Going back by 2 sites
    addSiteToHistory("www.yahoo.com"); // Navigating to UpGrad platform site
    System.out.println(
        mostRecentlyVisitedSite()); // Fetching most recently visited site (UpGrad Learn Platform)
    printBrowsingHistory(); // Printing browsing history

  }

}

/**
 * Your code should have the following Output:
 * <p>
 * true false www.upgrad.com www.yahoo.com [www.google.co.in, www.facebook.com, www.yahoo.com]
 */
