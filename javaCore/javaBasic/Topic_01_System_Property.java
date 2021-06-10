package javaBasic;

public class Topic_01_System_Property {
	private String osName = System.getProperty("os.Name");

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		String osName = System.getProperty("os.name");
		System.out.println(osName);

		Topic_01_System_Property topic01 = new Topic_01_System_Property();
	}

	private String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else if (isWindows()) {
			folderName = "\\" + folderName + "\\";
		} else {
			folderName = null;
		}
		return folderName;
	}

	private boolean isWindows() {
		return (osName.toLowerCase().indexOf("win") >= 0);
	}

	private boolean isMac() {
		return (osName.toLowerCase().indexOf("mac") >= 0);
	}

	private boolean isUnix() {
		return (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0);
	}

	private boolean isSolaris() {
		return (osName.toLowerCase().indexOf("sunos") >= 0);
	}

}
