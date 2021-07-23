package javaBasic;

public class Topic_08_File_Path {

	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");

		String catFileName = "cat.jpg";
		String footballteamFileName = "footballteam.jpg";
		String MUFileName = "MU.PNG";
		String catFileNamePath = projectLocation + getDirectorySlash("uploadFiles") + catFileName;
		String footballteamFileNamePath = projectLocation + getDirectorySlash("uploadFiles") + footballteamFileName;
		String MUFileNamePath = projectLocation + getDirectorySlash("uploadFiles") + MUFileName;

		System.out.println(catFileNamePath);
		System.out.println(footballteamFileNamePath);
		System.out.println(MUFileNamePath);
	}
	public static String getDirectorySlash(String folderName) {
		String separator = System.getProperty("file.separator");
//		System.out.println(separator);
//		separator = FileSystems.getDefault().getSeparator();
//		System.out.println(separator);
//		separator = File.separator;
//		System.out.println(separator);
		return separator + folderName + separator;
	}
}
