package hieunnph32561.fpoly.du_an_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import hieunnph32561.fpoly.du_an_1.framgment_custom.framgment_ds_dt;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    View headerLayout;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                Toolbar toolbar = findViewById(R.id.toolbar);
                NavigationView navigationView = findViewById(R.id.navigationview);
                drawerLayout = findViewById(R.id.drawerlayout);

                setSupportActionBar(toolbar);

                ActionBar actionBar = getSupportActionBar();
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setHomeAsUpIndicator(R.drawable.baseline_menu_24);

                // Xóa đoạn mã này
                Fragment defaultFragment = new framgment_ds_dt(); // Thay thế QlPhieuMuonFragment bằng Fragment mặc định bạn muốn hiển thị
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.framelayout, defaultFragment)
                        .commit();
                toolbar.setTitle("Quản lý phiếu mượn"); // Thay "Tên Fragment mặc định" bằng tiêu đề bạn muốn hiển thị

//
//                headerLayout = navigationView.getHeaderView(0);
//                textView = headerLayout.findViewById(R.id.textViewEmail);
//                Intent intent = getIntent();
//                String user = intent.getStringExtra("user");
//                textView.setText("" + user + "!");
//
//                if (user != null && user.equalsIgnoreCase("admin")) {
//                    navigationView.getMenu().findItem(R.id.sub_AddUser).setVisible(true);
//                }


                navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment = null;
                        if (item.getItemId() == R.id.framelayout) {
                            fragment = new framgment_ds_dt();
                        }

//                        if (item.getItemId() == R.id.dangxuat) {
//                            AlertDialog.Builder builder = new AlertDialog.Builder(Trang_chu.this);
//                            builder.setMessage("Do you want to exit ?")
//                                    .setTitle("Message")
//                                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
//                                        @Override
//                                        public void onClick(DialogInterface dialog, int which) {
//                                            Intent intent = new Intent(Trang_chu.this, Dang_Nhap.class);
//                                            startActivity(intent);
//
//                                            finish();
//                                        }
//                                    });
//                            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    dialog.dismiss();
//                                }
//                            });
//                            Dialog dialog = builder.create();
//                            dialog.show();
//                        }


                        if (fragment != null) {
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.framelayout, fragment)
                                    .commit();
                            toolbar.setTitle(item.getTitle());
                        }

                        drawerLayout.closeDrawer(GravityCompat.START);

                        return true;
                    }
                });
            }

            @Override
            public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == android.R.id.home) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                return super.onOptionsItemSelected(item);
            }
        }

