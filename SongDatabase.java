// --== CS400 File Header Information ==--
// Name: Weijie Zhou
// Email: wzhou226@wisc.edu
// Team: CG
// Role: Back End Developer
// TA: Yeping Wang
// Lecturer: Gary Dahl
// Notes to Grader: None

public class SongDatabase implements SongDatabaseInterface {
    private Database database;

    /**
     * Constructor that initializes the Red Black Tree
     */
    public SongDatabase() {
        this.database = new Database();
    }

    /**
     * @Description: Return the song specified by the song title
     * @Param: [songTitle]
     * @return: Song
     * @Author: Weijie Zhou
     * @Date: 2020/10/16
     */
    @Override
    public Song getSong(String songTitle) {
        return database.getSong(songTitle);
    }

    /**
     * @Description: Return whether there is a song in Song Database with the provided song title
     * @Param: [songTitle]
     * @return: boolean
     * @Author: Weijie Zhou
     * @Date: 2020/10/16
     */
    @Override
    public boolean hasSong(String songTitle) {
        return database.containsSong(songTitle);
    }

    /**
     * @Description: Adds a song into the song database, first creating a Song object and then add it into the database
     * @Param: [songTitle, artist, genre, year, bpm, duration]
     * @return: boolean
     * @Author: Weijie Zhou
     * @Date: 2020/10/16
     */
    @Override
    public boolean addSong(String songTitle, String artist, String genre, int year, int bpm, int duration) {
        if(songTitle == null || songTitle.equals("") || artist == null || artist.equals("") || genre == null || genre.equals("") || year <=0 || bpm <= 0 || duration <= 0){
            return false;
        }
        Song newSong = new Song(songTitle, artist, genre, year, bpm, duration);
        return database.addSong(newSong);
    }

    /**
     * @Description: Updates the artist of the song with associated song title
     * @Param: [songTitle, newArtist]
     * @return: boolean
     * @Author: Weijie Zhou
     * @Date: 2020/10/16
     */
    @Override
    public boolean updateArtist(String songTitle, String newArtist) {
        if( newArtist == null || newArtist.equals("")){
            return false;
        }
        Song song = database.getSong(songTitle);
        if (song == null)
            return false;
        else {
            song.setArtist(newArtist);
            return true;
        }
    }

    /**
     * @Description: Updates the genre of the song with associated song title
     * @Param: [songTitle, newGenre]
     * @return: boolean
     * @Author: Weijie Zhou
     * @Date: 2020/10/16
     */
    @Override
    public boolean updateGenre(String songTitle, String newGenre) {
        if( newGenre == null || newGenre.equals("")){
            return false;
        }
        try {
            Song song = database.getSong(songTitle);
            if (song == null)
                return false;
            else {
                song.setGenre(newGenre);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @Description: Updates the year of the song associated song title
     * @Param: [songTitle, newYear]
     * @return: boolean
     * @Author: Weijie Zhou
     * @Date: 2020/10/16
     */
    @Override
    public boolean updateYear(String songTitle, int newYear) {
        if(newYear <= 0){
            return false;
        }
        try {
            Song song = database.getSong(songTitle);
            if (song == null)
                return false;
            else {
                song.setYear(newYear);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @Description: Updates the bpm of the song with associated song title
     * @Param: [songTitle, newBPM]
     * @return: boolean
     * @Author: Weijie Zhou
     * @Date: 2020/10/16
     */
    @Override
    public boolean updateBpm(String songTitle, int newBpm) {
        if(newBpm <= 0){
            return false;
        }
        try {
            Song song = database.getSong(songTitle);
            if (song == null)
                return false;
            else {
                song.setBpm(newBpm);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @Description: Updates the duration of the song with associated song title
     * @Param: [songTitle, newDuration]
     * @return: boolean
     * @Author: Weijie Zhou
     * @Date: 2020/10/16
     */
    @Override
    public boolean updateDuration(String songTitle, int newDuration) {
        if(newDuration <= 0){
            return false;
        }
        try {
            Song song = database.getSong(songTitle);
            if (song == null)
                return false;
            else {
                song.setDuration(newDuration);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @Description: Gets the total number of the songs in the database
     * @Param: []
     * @return: int
     * @Author: Weijie Zhou
     * @Date: 2020/10/16
     */
    @Override
    public int getNumOfSong() {
        return database.size();
    }

    @Override
    public double getGenreFrequency(String genre) {
        double frequency = database.getFrequencyByGenre(genre);
        return frequency;
    }

    @Override
    public void clearDatabase() {
        database.clearDatabase();
    }
}
