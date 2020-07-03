package UpGrad.StackQueueAssignment;

import java.util.*;

class SiteStats1 {
    private String url;
    private int numVisits;

    /**
     * Constructor for the SiteStats class
     *
     * @param url
     *            String that represents an URL that the user has visited
     * @param numVisits
     *            An int that represents the number of times that the user has
     *            visited the url
     */
    public SiteStats1(String url, int numVisits) {
        this.url = url;
        this.numVisits = numVisits;
    }

    /**
     * This method returns the number of times that the user has visited the url.
     *
     * @return An int that represents the number of times that the user has visited
     *         the url
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
     * @param updatedNumVisits int that represents the number that we want to set numVisits to
     */
    public void setNumVisits(int updatedNumVisits) {
        this.numVisits = updatedNumVisits;
    }

    public String toString() {
        return this.url + " | " + this.numVisits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiteStats1 siteStats = (SiteStats1) o;
        return Objects.equals(url, siteStats.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}

public class StackQueueAssignmentB {
    private static Queue<SiteStats1> sites = new LinkedList<>();


    // Main method to list top n visited sites
    public static void listTopVisitedSites(Queue<SiteStats1> sites, int n) {
        sortQueue(sites);
        // WRITE CODE HERE
        if(sites.isEmpty()){
            System.out.println(new String[]{});
        }else{
            while(n>0 && !sites.isEmpty()){
                SiteStats1 siteStats = sites.remove();
                System.out.println(siteStats.getUrl());
                n--;
            }
        }


    }

    public static void sortQueue(Queue<SiteStats1> sites){
        if(!sites.isEmpty()){
            SiteStats1 siteStats = sites.remove();
            sortQueue(sites);
            insertSorted(sites, siteStats);
        }
    }

    public static void insertSorted(Queue<SiteStats1> sites, SiteStats1 siteStats) {
        if(sites.isEmpty() || siteStats.getNumVisits()<=sites.peek().getNumVisits()){
            int size = sites.size();
            int count = 0;
            while(size>0 && sites.peek().getNumVisits()>=siteStats.getNumVisits()){
                sites.add(sites.remove());
                count++;
                size--;
            }
            int count2 = sites.size() - count;
            sites.add(siteStats);
            while(count2>0){
                sites.add(sites.remove());
                count2--;
            }
        }else{
            int size = sites.size();
            sites.add(siteStats);
            while(size>0){
                sites.add(sites.remove());
                size--;
            }
        }
    }

    // Method to find the website in the queue and increment the visited count by 1, adding new node in case website is not found
    public static void updateCount(String url) {
        // WRITE CODE HERE
        int size = sites.size();
        SiteStats1 updatedSiteStats = null;
        while(size>0){
            SiteStats1 siteStats = sites.remove();
            if(siteStats.getUrl().equals(url)){
                updatedSiteStats = siteStats;
            }else{
                sites.add(siteStats);
            }
            size--;
        }
        if(updatedSiteStats==null){
            updatedSiteStats = new SiteStats1(url, 1);
        }else{
            updatedSiteStats.setNumVisits(updatedSiteStats.getNumVisits()+1);
        }
        sites.add(updatedSiteStats);

    }

    public static void main(String[] args) {
        String[] visitedSites = { "www.google.co.in", "www.google.co.in", "www.facebook.com", "www.upgrad.com", "www.google.co.in", "www.youtube.com",
                "www.facebook.com", "www.upgrad.com", "www.facebook.com", "www.google.co.in", "www.microsoft.com", "www.9gag.com", "www.netflix.com",
                "www.netflix.com", "www.9gag.com", "www.microsoft.com", "www.amazon.com", "www.amazon.com", "www.uber.com", "www.amazon.com",
                "www.microsoft.com", "www.upgrad.com" };
        System.out.println(visitedSites.length);

        for (String url : visitedSites) {
            updateCount(url);
        }
        //Iterator<SiteStats> iterator = sites.iterator();

        listTopVisitedSites(sites, 5);
        /*while(iterator.hasNext()){
            SiteStats a = (SiteStats) iterator.next();
            System.out.println(a.getUrl()+":"+a.getNumVisits());

        }*/

    }
}
