// --== CS400 File Header Information ==--
// Name: Weijie Zhou
// Email: wzhou226@wisc.edu
// Team: CG
// Role: Back End Developer
// TA: Yeping Wang
// Lecturer: Gary Dahl
// Notes to Grader: None

public interface SongDatabaseInterface {
    public Song getSong(String songTitle);

    public boolean hasSong(String songTitle);

    public boolean addSong(String songTitle, String artist, String genre, int year, int bpm,
                           int duration);

    public boolean updateArtist(String songTitle, String newArtist);

    public boolean updateGenre(String songTitle, String newGenre);

    public boolean updateYear(String songTitle, int newYear);

    public boolean updateBpm(String songTitle, int newBpm);

    public boolean updateDuration(String songTitle, int newDuration);

    public int getNumOfSong();

    public double getGenreFrequency(String genre);

    public void clearDatabase();
}
