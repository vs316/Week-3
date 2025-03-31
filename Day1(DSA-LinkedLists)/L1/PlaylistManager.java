package DSA.LinkedLists;

class SongNode {
    String songName;
    String artist;
    double duration; // In minutes
    SongNode next;

    public SongNode(String songName, String artist, double duration) {
        this.songName = songName;
        this.artist = artist;
        this.duration = duration;
        this.next = this; // Point to itself for circularity
    }
}

class CircularPlaylist {
    SongNode head = null;
    private SongNode tail = null;

    public void addSongAtBeginning(String songName, String artist, double duration) {
        SongNode newNode = new SongNode(songName, artist, duration);
        if (head == null) {//empty list
            head = newNode;
            tail = newNode;
            tail.next = head; //Circular Link
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; //update tail to point to the new head
        }
    }

    //Add a song at the end
    public void addSongAtEnd(String songName, String artist, double duration) {
        SongNode newNode = new SongNode(songName, artist, duration);
        if (head == null) {//Empty list
            head = newNode;
            tail = newNode;
            tail.next = head;//Circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; //maintain circularity
        }
    }

    public void deleteSongByName(String songName) {
        if (head == null) {
            System.out.println("The playlist is empty");
            return;
        }
        SongNode current = head;
        SongNode previous = null;
        do {
            if (current.songName.equalsIgnoreCase(songName)) {
                if (current == head) {//if deleting the head
                    if (head == tail) {//Only one song exists
                        head = null;
                        tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;//update tail's next pointer
                    }
                } else {//deleting any other node
                    previous.next = current.next;
                    if (current == tail) {//if deleting the tail
                        tail = previous;
                    }
                }
                System.out.println("Song deleted: " + songName);
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
        System.out.println("Song not found: " + songName);
    }

    public void displayPlaylist(){
        if(head==null){
            System.out.println("The playlist is empty");
            return;
        }
        SongNode current=head;
        System.out.println("Playlist:");
        do{
            System.out.println("Song: "+current.songName+", Artist: "+current.artist+", Duration: "+current.duration+" minutes");
            current=current.next;
        }while(current!=head);
    }
    public SongNode playNext(SongNode current){
        if(head==null){
            System.out.println("The playlist is empty");
            return null;
        }
        System.out.println("Now playing: "+current.next.songName+" by "+current.next.artist);
        return current.next;
    }

}


public class PlaylistManager {
    public static void main(String[] args) {
        CircularPlaylist playlist = new CircularPlaylist();

        // Add songs
        playlist.addSongAtEnd("Song1", "Artist1", 3.5);
        playlist.addSongAtEnd("Song2", "Artist2", 4.0);
        playlist.addSongAtBeginning("Song3", "Artist3", 2.5);

        // Display playlist
        playlist.displayPlaylist();

        // Delete a song
        playlist.deleteSongByName("Song2");
        playlist.displayPlaylist();

        // Play next song
        SongNode currentSong = playlist.head;
        currentSong = playlist.playNext(currentSong);
    }
}
