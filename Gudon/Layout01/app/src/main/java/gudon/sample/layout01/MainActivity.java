/*
 * fill_parentは「API Level 8（Android2.2）」から非推奨になっていて、 
 * 代わりにmatch_parentを使う事が推奨されています。
 * match_parentとfill_parentは同じ値（-1）が定義されていて同じ動作をしますが、
 * 今後はmatch_parentを使うようにした方が良いようです。
 */

package gudon.sample.layout01;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}