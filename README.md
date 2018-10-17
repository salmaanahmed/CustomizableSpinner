# CustomizableSpinner
Customizable spinner is an easy to implement spinner which populates without any creating adapter or providing layout.
You dont need to create adapter for binding the list to the spinner.
Also no need to create multiple layouts for customizing the dropdown view or the spinner view.

Motivation for this spinner was to make the code clean and strip out the boilerplate.
Spinner should be as easy to implement as its easy to use

<br>
<img height="400" src="https://github.com/salmaanahmed/CustomizableSpinner/blob/master/spinner_animation.gif?raw=true" />
<br>

# Installation
```CustomizableSpinner``` can be installed using Maven, Gradle, or manually.

# Maven
**Step 1.** Add the JitPack repository to your build file
``` xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
**Step 2.** Add the dependency
``` xml
<dependency>
    <groupId>com.github.salmaanahmed</groupId>
    <artifactId>CustomizableSpinner</artifactId>
    <version>1.0</version>
</dependency>
```

# Gradle
**Step 1.** Add the JitPack repository to your build file
``` gradle
allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
}
```
**Step 2.** Add the dependency
``` gradle
dependencies {
        implementation 'com.github.salmaanahmed:CustomizableSpinner:1.0'
}
```
# Manual Installation
If you prefer not to use either of the above mentioned dependency managers, you can integrate Spinner into your project manually by adding the files contained in the java folder to your project.

# Spinner in XML
Create spinner in XML as follows
```xml
    <salmaan.ahmsal.com.customizablespinner.CustomizableSpinner
            android:id="@+id/spinner"
            android:layout_width="0dp"
            android:layout_weight="1"
            android:layout_height="35dp" />
```

# Set Attributes
Set attributes in the xml for both spinner view and dropdown view instead of creating two different views and passing them to spinner.
By doing this you can avoid multiple files in your resource layouts and assigning the layouts to adapter and spinner.
This will keep your code cleaner
``` xml
<salmaan.ahmsal.com.customizablespinner.CustomizableSpinner
    android:id="@+id/spinner"
    android:layout_width="0dp"
    android:layout_weight="1"
    app:selectedTextSize="18sp"
    app:dropDownTextSize="17sp"
    app:selectedTextColor="@color/colorAccent"
    app:dropDownTextColor="@color/colorPrimaryDark"
    app:selectedBackgroundColor="@android:color/white"
    app:dropDownBackgroundColor="@android:color/background_light"
    app:selectedHeight="50dp"
    app:dropDownHeight="50dp"
    app:selectedMaxLines="1"
    app:dropDownMaxLines="1"
    app:selectedPadding="3dp"
    app:dropDownPadding="5dp" />
```

# Couple Of Complimentry Things
You can now add listener to your spinner as lambda expression and get both string and index
```kotlin
// Add listener to the spinner
spinner.selectionChanged { index, string ->
    textView.text = "$index: $string"
}
```
You can now also select the value by passing string itself instead of passing index
```kotlin
// Set selected value
spinner.setSelectedValue("Magic")
```
Write clean and simple code by using this spinner.

# Contributions and Licence
```CustomizableSpinner``` is available under the MIT license. See the [LICENSE](https://github.com/salmaanahmed/SAExpandableButton/blob/master/LICENCE.txt) file for more info.

Pull requests are welcome! The best contributions will consist of substitutions or configurations for classes/methods known to block the main thread during a typical app lifecycle.

I would love to know if you are using CustomizableSpinner in your app, send an email to [Salmaan Ahmed](mailto:salmaan.ahmed@hotmail.com)
