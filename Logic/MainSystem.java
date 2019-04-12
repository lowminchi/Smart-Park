package logic;

import java.util.ArrayList;

import Data.DatabaseManager;
import Data.TempContributorRecord;
import Data.TempMusicRecord;
import Data.TempProgramRecord;
import Data.TempUserRecord;

public class MainSystem {
	private String name;

	DatabaseManager db = new DatabaseManager();

	public MainSystem(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isValidUser(String username, String password) {
		return db.verifyUser(username, password);
	}

	public boolean isValidContributor(String username, String password) {
		return db.verifyContributor(username, password);
	}

	public ArrayList<User> getAllUser() {
		ArrayList<User> userlist = new ArrayList<User>();
		ArrayList<TempUserRecord> userRegister = db.getUserRegister();

		for (TempUserRecord tempuser : userRegister) {
			User users = new User(tempuser.getUsername(), tempuser.getPassword());
			userlist.add(users);

		}
		return userlist;

	}
	
	public User getUser(String username, String password) {
		TempUserRecord tempuser = db.getUser(username, password);
		User user = new User(tempuser.getUsername(), tempuser.getPassword());
		return user;
	}

	public ArrayList<Music> getAllMusic() {
		ArrayList<Music> musicList = new ArrayList<Music>();
		ArrayList<TempMusicRecord> musicRegister = db.getMusic();

		for (TempMusicRecord tempmusic : musicRegister) {
			Music musics = new Music(tempmusic.getName(), tempmusic.getGenre(), tempmusic.getLength(),
					tempmusic.getMusicmode());
			musicList.add(musics);
		}
		return musicList;

	}

	public ArrayList<Programs> getAllProgram() {
		ArrayList<Programs> programList = new ArrayList<Programs>();
		ArrayList<TempProgramRecord> programRegister = db.getProgram();

		for (TempProgramRecord tempprogram : programRegister) {
			Programs programs = new Programs(tempprogram.getAuthors(), tempprogram.getDetails(), tempprogram.getPrice(),
					tempprogram.getTitle(), tempprogram.getPictures(), tempprogram.isJoined());
			programList.add(programs);
		}

		return programList;

	}

	public ArrayList<Contributor> getAllContributor() {
		ArrayList<Contributor> contributorlist = new ArrayList<Contributor>();
		ArrayList<TempContributorRecord> contributorRegister = db.getContributorRegister();

		for (TempContributorRecord tempcontributor : contributorRegister) {
			Contributor contributors = new Contributor(tempcontributor.getUsername(), tempcontributor.getPassword(),tempcontributor.getGender(), tempcontributor.getProfession(), tempcontributor.getContactNo());
			contributorlist.add(contributors);
		}

		return contributorlist;

	}

	public void addNewProgram() {

	}
}
