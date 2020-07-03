package UpGrad.StackQueueAssignment;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class SiteStats {

  private String url;
  private int numVisits;

  /**
   * Constructor for the SiteStats class
   *
   * @param url       String that represents an URL that the user has visited
   * @param numVisits An int that represents the number of times that the user has visited the url
   */
  public SiteStats(String url, int numVisits) {
    this.url = url;
    this.numVisits = numVisits;
  }

  /**
   * This method returns the number of times that the user has visited the url.
   *
   * @return An int that represents the number of times that the user has visited the url
   */
  public int getNumVisits() {
    return this.numVisits;
  }

  /**
   * This method returns the url that we are currently tracking
   *
   * @return A String that represents the url that we are currently tracking
   */
  public String getUrl() {
    return this.url;
  }

  /**
   * This method updates the number of times that we have visited the url
   *
   * @param updatedNumVisits an int that represents the number that we want to set numVisits to
   */
  public void setNumVisits(int updatedNumVisits) {
    this.numVisits = updatedNumVisits;
  }

  public String toString() {
    return this.url + " | " + this.numVisits;
  }

}

public class SolutionB {

  private static Queue<SiteStats> sites = new LinkedList<>();

  /**
   * Lists out the top n visited sites. To do so, it first sorts the queue in descending order using
   * sortQueue method. Time complexity: O(N^2).
   *
   * @param sites Queue of URLs with visit count in the browsing history
   * @param n     Top n sites to be displayed
   */
  public static void listTopVisitedSites(Queue<SiteStats> sites, int n) {
    // WRITE CODE HERE
    if (sites.isEmpty()) {
      /*
       * AbstractCollection.java's toString method prints the LinkedList as an empty [] by default
       * if it is empty.
       */
      System.out.println(sites);
    } else if (n > 0 && n <= sites.size()) {
      sortQueue(sites);
      Iterator<SiteStats> iterator = sites.iterator();
      int iterationCount = n;
      while (iterationCount > 0 && iterator.hasNext()) {
        SiteStats siteStats = iterator.next();
        System.out.print(
            (iterationCount == n ? "[" : " ") + siteStats + (iterationCount == 1 ? "]" : ","));
        iterationCount--;
      }
    } else {
      System.out
          .println(
              "Enter a valid value for listing top visited sites. Starting from 1, up to: " + sites
                  .size());
    }
  }

  /**
   * Sorting the queue of browsing history in descending order of visit count and if visit count is
   * equal, then according to the recency of visit. Time complexity: O(N^2).
   *
   * @param sites Queue of URLs with visit count in the browsing history
   */
  public static void sortQueue(Queue<SiteStats> sites) {
    if (!sites.isEmpty()) {
      int size = sites.size();
      for (int i = 0; i < size; i++) {
        SiteStats max = null;
        int iterationCount = size - i;
        while (iterationCount > 0) {
          if (max == null) {
            max = sites.remove();
          } else if (!sites.isEmpty() && sites.peek().getNumVisits() >= max.getNumVisits()) {
            sites.add(max);
            max = sites.remove();
          } else if (!sites.isEmpty()) {
            sites.add(sites.remove());
          }
          iterationCount--;
        }
        for (int j = 0; j < i; j++) {
          sites.add(sites.remove());
        }
        sites.add(max);
      }
    }
  }

  /**
   * Stores the URL of the website visited in a queue. If website already exists in queue, then the
   * visit count is incremented by 1 and it is moved to the back of the queue. If it doesn't exist,
   * then adds it. For example, if the queue contains [{"a": 2}, {"b": 1}] and now "a" is being
   * added to the queue again, then the queue becomes [{"b": 1},{"a": 3}]. This is done to ensure
   * that recently visited sites stay at the end. "This also had the benefit of allowing quick
   * updates to the numVisits variable, as user behaviour showed that they were more likely to visit
   * sites that they had not recently gone to. Thus following a somewhat FIFO approach." If url is
   * null, then doesn't store it in the queue and displays an appropriate error message. Time
   * complexity: O(N).
   *
   * @param url Website URL to add to the queue.
   */
  public static void updateCount(String url) {
    // WRITE CODE HERE
    if (url != null) {
      int size = sites.size();
      SiteStats updatedSiteStats = null;
      while (size > 0) {
        SiteStats siteStats = sites.remove();
        if (siteStats.getUrl().equals(url)) {
          updatedSiteStats = siteStats;
        } else {
          sites.add(siteStats);
        }
        size--;
      }
      if (updatedSiteStats == null) {
        updatedSiteStats = new SiteStats(url, 1);
      } else {
        updatedSiteStats.setNumVisits(updatedSiteStats.getNumVisits() + 1);
      }
      sites.add(updatedSiteStats);
    } else {
      System.out.println("Invalid URL:" + url);
    }

  }

  // Main method to list top n visited sites
  public static void main(String[] args) {
    String[] visitedSites = {"www.google.co.in", "www.google.co.in", "www.facebook.com",
        "www.upgrad.com", "www.google.co.in", "www.youtube.com",
        "www.facebook.com", "www.upgrad.com", "www.facebook.com", "www.google.co.in",
        "www.microsoft.com", "www.9gag.com", "www.netflix.com",
        "www.netflix.com", "www.9gag.com", "www.microsoft.com", "www.amazon.com", "www.amazon.com",
        "www.uber.com", "www.amazon.com",
        "www.microsoft.com", "www.upgrad.com"};

    for (String url : visitedSites) {
      updateCount(url);
    }
    listTopVisitedSites(sites, 5);
  }

}
