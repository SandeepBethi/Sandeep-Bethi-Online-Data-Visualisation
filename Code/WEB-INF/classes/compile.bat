set classpath=lib/gnujaxp.jar;lib/jfreechart-1.0.13.jar;lib/jfreechart-1.0.13-experimental.jar;lib/jfreechart-1.0.13-swt.jar;lib/swtgraphics2d.jar;lib/jcommon-1.0.16.jar;lib/iText-2.1.5.jar;lib/poi-3.5-FINAL.jar;lib/poi-ooxml-3.5-beta5.jar;lib/commons-fileupload-1.2.2.jar;lib/commons-io-2.1.jar;C:/Tomcat 6.0/lib/servlet-api.jar;.;
del *.class
javac -d . *.java
pause