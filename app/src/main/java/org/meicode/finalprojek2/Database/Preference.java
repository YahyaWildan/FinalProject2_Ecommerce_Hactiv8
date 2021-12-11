package org.meicode.finalprojek2.Database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Preference {
   public static final DatabaseReference DATABASE_REFERENCE = FirebaseDatabase.getInstance().getReferenceFromUrl("https://finalprojek2-e5802-default-rtdb.firebaseio.com/");

}
