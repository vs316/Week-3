package DSA.LinkedLists;

class MovieNode {
    String movieTitle;
    String director;
    int yearOfRelease;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String movieTitle, String director, int yearOfRelease, double rating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MoviesLinkedList {
    private MovieNode head;
    private MovieNode tail;

    public void addMovieAtBeginning(String movieTitle, String director, int yearOfRelease, double rating) {
        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        if (head == null) {//empty list
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Added movie at the beginning: " + movieTitle);
    }

    public void addMovieAtEnd(String movieTitle, String director, int yearOfRelease, double rating) {
        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        if (head == null) {//empty list
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Added movie at the end: " + movieTitle);
    }

    public void addMovieAtPosition(String movieTitle, String director, int yearOfRelease, double rating, int position) {
        if (position == 1) {
            addMovieAtBeginning(movieTitle, director, yearOfRelease, rating);
            return;
        }
        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        MovieNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            if (temp == null) throw new IndexOutOfBoundsException("Invalid position.");
            temp = temp.next;
        }
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {//if adding at the end, update the tail
            tail = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
        System.out.println("Added movie at position " + position + ": " + movieTitle);
    }

    public void removeMovieByTitle(String movieTitle) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        MovieNode temp = head;
        while (temp != null && !temp.movieTitle.equalsIgnoreCase(movieTitle)) {
            temp = temp.next;
        }
        if (temp == null) {//Movie not found
            System.out.println("Movie not found: " + movieTitle);
            return;
        }
        if (temp == head) {//removing the head
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {//if list becomes empty
                tail = null;
            }
        } else if (temp == tail) {//removing the tail
            tail = tail.prev;
            tail.next = null;
        } else {//removing a node in the middle
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        System.out.println("Removed movie: " + movieTitle);
    }

    public void searchMovies(String director, Double rating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if ((temp.director.equalsIgnoreCase(director))
                    || (rating != null && temp.rating == rating)) {
                System.out.println("Found movie: " + temp.movieTitle + " by " + temp.director + " with rating " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found matching the criteria.");
        }
    }
    public void displayMoviesForward(){
        MovieNode temp=head;
        if(temp==null){
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("Movies in Forward Order: ");
        while(temp!=null){
            System.out.println(temp.movieTitle+" by "+temp.director+" ( "+temp.yearOfRelease+" ) - Rating: "+temp.rating);
            temp=temp.next;
        }
    }
    public void displayMoviesReverse(){
        MovieNode temp=tail;
        if(temp==null){
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("Movies in Reverse Order: ");
        while(temp!=null){
            System.out.println(temp.movieTitle+" by "+temp.director+" ( "+temp.yearOfRelease+" ) - Rating: "+temp.rating);
            temp=temp.prev;
        }
    }
    public void updateMovieRating(String movieTitle, double newRating){
        MovieNode temp=head;
        while(temp!=null){
            if(temp.movieTitle.equalsIgnoreCase(movieTitle)){
                temp.rating=newRating;
                System.out.println("Updated rating of "+movieTitle+" to "+newRating);
                return;
            }
            temp=temp.next;
        }
        System.out.println("Movie not found: "+movieTitle);
    }
}


public class MovieManagementSystem {
    public static void main(String[] args) {
        MoviesLinkedList moviesList = new MoviesLinkedList();

        // Add movies
        moviesList.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        moviesList.addMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        moviesList.addMovieAtPosition("The Dark Knight", "Christopher Nolan", 2008, 9.0, 2);

        // Display movies in forward and reverse order
        moviesList.displayMoviesForward();
        moviesList.displayMoviesReverse();

        // Search for movies
        System.out.println("\nSearching for movies by Christopher Nolan:");
        moviesList.searchMovies("Christopher Nolan", null);

        // Update a movie's rating
        moviesList.updateMovieRating("Interstellar", 9.0);

        // Display updated list
        moviesList.displayMoviesForward();

        // Remove a movie
        moviesList.removeMovieByTitle("Inception");
        moviesList.displayMoviesForward();
    }
}




