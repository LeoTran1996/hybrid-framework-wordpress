cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libExtentReportV2\*;%ProjectPath%libLogging\*;%ProjectPath%libraries\*;%ProjectPath%libReportNG\*;%ProjectPath%libraryWebDriverManagerment\*" org.testng.TestNG "%ProjectPath%bin\runnopCommerce.xml"
pause