# Using the AMOR Conflict Detection #

This component is mainly targeted at being integrated into a common versioning system in order to replace the traditional text-based conflict detection by AMOR's more sophisticated model-based conflict detection.

However, having installed AMOR's conflict detection component (cf. [Installation](http://code.google.com/a/eclipselabs.org/p/amor-conflict-detection/wiki/Installation)), you can also directly test the conflict detection capabilities by creating three model versions and apply the conflict detection to them. This works as follows.

Select three model versions, right-click them, and select _Conflict Detection_ -> _Detect Conflicts_.

![http://amor-conflict-detection.eclipselabs.org.codespot.com/files/ui_detect_conflicts.png](http://amor-conflict-detection.eclipselabs.org.codespot.com/files/ui_detect_conflicts.png)

Next, select the original model version in the popup window (having the workd _origin_ in the file name in our [example models](http://code.google.com/a/eclipselabs.org/p/amor-conflict-detection/downloads/detail?name=ConflictDetectionTest.zip)) and proceed. Now, a conflict report is generated and saved to a location of your choice. This conflict report can now be opened using a dedicated conflict report viewer to inspect the detected conflicts.

![http://amor-conflict-detection.eclipselabs.org.codespot.com/files/ui_conflict_report.png](http://amor-conflict-detection.eclipselabs.org.codespot.com/files/ui_conflict_report.png)

Please note that we provide some [test models](http://code.google.com/a/eclipselabs.org/p/amor-conflict-detection/downloads/detail?name=ConflictDetectionTest.zip) for you.