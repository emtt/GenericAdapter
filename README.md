
[![](https://jitpack.io/v/emtt/GenericAdapter.svg)](https://jitpack.io/#emtt/GenericAdapter)
# GenericAdapter
**GenericAdapter** is an Android library for any type of model list. It requires **DataBinding** enabled.

### Install
Include Gradle **build.gradle** project level jitpack dependency:
```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

Gradle dependency **build.gradle** app level:
```
  implementation 'com.github.emtt:GenericAdapter:LastVersion'
```

### How to use?
Firts off, you need enable DataBinding in your android app **build.gradle** inside  android{} section:
```
dataBinding {
        enabled = true
    }
```
Next, set up a RecyclerView in a Layout as usually you do:

    <?xml version="1.0" encoding="utf-8"?>  
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"  
      xmlns:app="http://schemas.android.com/apk/res-auto"  
      xmlns:tools="http://schemas.android.com/tools"  
      android:layout_width="match_parent"  
      android:layout_height="match_parent"  
      tools:context=".MainActivity">  
      
     <android.support.v7.widget.RecyclerView  
      android:id="@+id/rvPosts"  
      android:layout_width="match_parent"  
      android:layout_height="match_parent"  
      android:layout_marginStart="8dp"  
      android:layout_marginTop="8dp"  
      android:layout_marginEnd="8dp"  
      android:layout_marginBottom="8dp"  
      android:clipToPadding="false"/>  
      
    </android.support.constraint.ConstraintLayout>

Now, create a model if not have one:

      public class Person {  
      public String Name;  
      public int Age;  
      
     public String getName() {  
      return Name;  
      }  
      
      public void setName(String name) {  
      Name = name;  
      }  
      
      public int getAge() {  
      return Age;  
      }  
      
      public void setAge(int age) {  
      Age = age;  
      }  
    }

Next, create a layout for the items that populating the RecyclerView (*notice the **variable** tag*  and TextView's text property). After create the layout click on Android Studio's menu Build -> Rebuild Project for create BR class.

    <?xml version="1.0" encoding="utf-8"?>  
    <layout xmlns:android="http://schemas.android.com/apk/res/android"  
      xmlns:app="http://schemas.android.com/apk/res-auto"  
      xmlns:tools="http://schemas.android.com/tools">  
      
     <data>  
      
	     <variable  
	      name="person"  
	      type="mobilize.mx.genericadapter.model.Person" />  
      
     </data>  
      
     <android.support.constraint.ConstraintLayout  
      android:layout_width="match_parent"  
      android:layout_height="wrap_content">  
      
     <TextView  
      android:id="@+id/txtPerson"  
      android:layout_width="match_parent"  
      android:layout_height="wrap_content"  
      android:layout_marginStart="8dp"  
      android:layout_marginTop="8dp"  
      android:layout_marginEnd="8dp"  
      app:layout_constraintEnd_toEndOf="parent"  
      app:layout_constraintStart_toStartOf="parent"  
      app:layout_constraintTop_toTopOf="parent"  
      android:text="@{person.name}" />  
      
     </android.support.constraint.ConstraintLayout>  
    </layout>
***Don't forget Rebuild the project.***

*Until now it's the same what you do when need a RecyclerView in your Activity/Fragment. Nothing but the same.*

In your Activity/Fragment implements **ItemListener** Interface:

    public class MainActivity extends AppCompatActivity implements LifecycleOwner, ItemListener {

and his method:

    @Override  
    public void onClick(Object model) {  
        
    }
Finally, setup the GenericAdapter:

    private void setupRecycler() {  
      Person person1 = new Person();  
      person1.setAge(18);  
      person1.setName("John");  

      Person person2 = new Person();  
      person2.setAge(36);  
      person2.setName("Paul");  

      Person person3 = new Person();  
      person3.setAge(24);  
      person3.setName("Rosa");  

      personList.add(person1);  
      personList.add(person2);  
      personList.add(person3);  

      recyclerView = findViewById(R.id.rvPosts);  
      RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);  
      recyclerView.setLayoutManager(layoutManager);  

      Adapter adapter = new Adapter<>(personList, R.layout.item_person, this, BR.person);  
      recyclerView.setAdapter(adapter);
    }

It's all.
#### Contact & Help
-   **email**:  [emoralest@gmail.com](emoralest@gmail.com)
- **Linkedln**: [emtt](https://www.linkedin.com/in/efrain-morales-ab502898/)

welcome to commit [issue](https://github.com/emtt/GenericAdapter/issues) & [pr](https://github.com/emtt/GenericAdapter/pulls)

Based in the idea of [Pushan Dhabalia](https://medium.com/@pushan25/android-generic-multi-type-recycler-view-adapter-through-data-binding-a0327bdccd20)

## License

This library is licensed under the  [Apache Software License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

See  [`LICENSE`](https://github.com/hanks-zyh/SmallBang/blob/master/LICENSE)  for full of the license text.

```
Copyright (C) 2015 [Hanks](https://github.com/hanks-zyh)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

