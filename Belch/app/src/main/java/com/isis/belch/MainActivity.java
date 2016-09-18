package com.isis.belch;

<<<<<<< HEAD
import android.Manifest;
import android.annotation.TargetApi;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
=======
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
>>>>>>> origin/master
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
<<<<<<< HEAD
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
=======
>>>>>>> origin/master
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "Activity";

<<<<<<< HEAD
    String string = "";

    //bluetooth
    private static final String TAG1 = "bluetooth2";
    private TextView txtArduino, txtLongitude, txtLatitude, txtPlate;
=======
    String string="";

    //bluetooth
    private static final String TAG1 = "bluetooth2";
    private TextView txtArduino,txtLongitude, txtLatitude, txtPlate;
>>>>>>> origin/master
    Handler h;
    private static String sbprint;


    final int RECIEVE_MESSAGE = 1;        // Status  for Handler
    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private StringBuilder sb = new StringBuilder();

    private ConnectedThread mConnectedThread;

    // SPP UUID service
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    // MAC-address of Bluetooth module (you must edit this line)
    private static String address = "30:15:01:23:12:96";


<<<<<<< HEAD
//    public String latitudeLocation = "", longitudeLocation = "";
//    protected LocationManager locationManager;
//    protected LocationListener locationListener;

    private BroadcastReceiver broadcastReceiver;
=======
    public String latitudeLocation="",longitudeLocation="";
    protected LocationManager locationManager;
    protected LocationListener locationListener;

>>>>>>> origin/master


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtArduino = (TextView) findViewById(R.id.txtArduino); // for display the received data from the Arduino

<<<<<<< HEAD
        txtLatitude = (TextView) findViewById((R.id.txtLatitude));
        txtLongitude = (TextView) findViewById(R.id.txtLongitude);
=======
        txtLatitude =(TextView) findViewById((R.id.txtLatitude));
        txtLongitude =(TextView) findViewById(R.id.txtLongitude);
>>>>>>> origin/master

        txtPlate = (TextView) findViewById(R.id.txtPlate);


<<<<<<< HEAD
        btAdapter = BluetoothAdapter.getDefaultAdapter();       // get Bluetooth adapter
        checkBTState();
=======
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        CurrentLocation locationListener = new CurrentLocation();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,locationListener);

>>>>>>> origin/master


       h = new Handler() {

            public void handleMessage(android.os.Message msg) {
                switch (msg.what) {
                    case RECIEVE_MESSAGE:                                                   // if receive massage
                        byte[] readBuf = (byte[]) msg.obj;
                        String strIncom = new String(readBuf, 0, msg.arg1);                 // create string from bytes array
                        sb.append(strIncom);                                                // append string
                        int endOfLineIndex = sb.indexOf("\r\n");                            // determine the end-of-line
                        if (endOfLineIndex > 0) {                                            // if end-of-line,
                            sbprint = sb.substring(0, endOfLineIndex);               // extract string
<<<<<<< HEAD
                            sb.delete(0, sb.length());// and clear
                            if(string.contains("Poor")){
                                txtArduino.setText("Poor");
                            }else if(string.contains("Fair")){
                                txtArduino.setText("Fair");
                            }else if (string.contains("Very Good")){
                                txtArduino.setText("Very Good");
                            }else if(string.contains("Excellent")){
                                txtArduino.setText("Excellent");
                            }else if (string.contains("Good")){
                                txtArduino.setText("Good");
                            }


=======
                            sb.delete(0, sb.length());   // and clear
                            //  String sbprint2 = String.valueOf(String.format("%.2d", sbprint));
//                            txtArduino.setText("Distance: " + sbprint + " ft");            // update TextView
//                            Log.e(TAG,"Distance: " + sbprint + " ft");
                            txtArduino.setText(string);
>>>>>>> origin/master
                        }
                        //Log.d(TAG, "...String:"+ sb.toString() +  "Byte:" + msg.arg1 + "...");
                        break;
                }
<<<<<<< HEAD
            }
        };

        if(!runtime_permissions()){
            enable_buttons();
        }


    }

    private void enable_buttons(){
        Intent i = new Intent(getApplicationContext(),GPS_Service.class);
        startService(i);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 100){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                enable_buttons();
            }else{
                runtime_permissions();
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private boolean runtime_permissions(){
        if(Build.VERSION.SDK_INT >+ 10 && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermissions((new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}),100);
            return true;
        }
        return false;
=======
            };
        };

        btAdapter = BluetoothAdapter.getDefaultAdapter();       // get Bluetooth adapter
        checkBTState();


>>>>>>> origin/master

    }


<<<<<<< HEAD

=======
>>>>>>> origin/master
    private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {
        if (Build.VERSION.SDK_INT >= 10) {
            try {
                final Method m = device.getClass().getMethod("createInsecureRfcommSocketToServiceRecord", new Class[]{UUID.class});
                return (BluetoothSocket) m.invoke(device, MY_UUID);
            } catch (Exception e) {
                Log.e(TAG1, "Could not create Insecure RFComm Connection", e);
            }
        }
        return device.createRfcommSocketToServiceRecord(MY_UUID);

    }

    @Override
    public void onPause() {
        super.onPause();

        try {
            btSocket.close();
        } catch (IOException e2) {
            errorExit("Fatal Error", "In onPause() and failed to close socket." + e2.getMessage() + ".");
        }
        finish();
    }


    private void checkBTState() {
        // Check for Bluetooth support and then check to make sure it is turned on
        // Emulator doesn't support Bluetooth and will return null

        if (btAdapter == null) {
            errorExit("Fatal Error", "Bluetooth not support");
        } else {
            try {
                if (btAdapter.isEnabled()) {
                    Log.d(TAG1, "...Bluetooth ON...");

                } else {
                    //Prompt user to turn on Bluetooth
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, 1);
                }
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();

<<<<<<< HEAD


=======
>>>>>>> origin/master
        // Set up a pointer to the remote node using it's address.
        BluetoothDevice device = btAdapter.getRemoteDevice(address);

        // Two things are needed to make a connection:
        //   A MAC address, which we got above.
        //   A Service ID or UUID.  In this case we are using the
        //     UUID for SPP.

        try {
            btSocket = createBluetoothSocket(device);
        } catch (IOException e) {
            errorExit("Fatal Error", "In onResume() and socket create failed: " + e.getMessage() + ".");
        }

        // Discovery is resource intensive.  Make sure it isn't going on
        // when you attempt to connect and pass your message.
        btAdapter.cancelDiscovery();

        // Establish the connection.  This will block until it connects.
        Log.d(TAG1, "...Connecting...");
        try {
            btSocket.connect();
            Log.d(TAG1, "....Connection ok...");
        } catch (IOException e) {
            try {
                btSocket.close();
            } catch (IOException e2) {
                errorExit("Fatal Error", "In onResume() and unable to close socket during connection failure" + e2.getMessage() + ".");
            }
        }

        // Create a data stream so we can talk to server.
        Log.d(TAG1, "...Create Socket...");

        mConnectedThread = new ConnectedThread(btSocket);
        mConnectedThread.start();

<<<<<<< HEAD

        if(broadcastReceiver == null){
            broadcastReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    String lat =intent.getExtras().get("cooLat")+" ";
                    String lo = intent.getExtras().get("cooLong")+" ";
                    txtLatitude.setText(lat);
                    txtLongitude.setText(lo);
                }
            };
        }
        registerReceiver(broadcastReceiver,new IntentFilter("location_update"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(broadcastReceiver != null){
            unregisterReceiver(broadcastReceiver);
        }
=======
>>>>>>> origin/master
    }

    private void errorExit(String title, String message) {
        Toast.makeText(getBaseContext(), title + " - " + message, Toast.LENGTH_LONG).show();
        finish();
    }


    private class ConnectedThread extends Thread {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[1024];  // buffer store for the stream
            int bytes; // bytes returned from read()

            // Keep listening to the InputStream until an exception occurs
            while (true) {
                try {
                    // Read from the InputStream
                    bytes = mmInStream.read(buffer);        // Get number of bytes and message in "buffer"
                    h.obtainMessage(RECIEVE_MESSAGE, bytes, -1, buffer).sendToTarget();     // Send to message queue Handler
                    string = new String(buffer);
                    Log.e(TAG,string);

                } catch (IOException e) {
                    break;
                }
            }
        }


    }

<<<<<<< HEAD
=======
    public class CurrentLocation implements LocationListener {

        public void onLocationChanged(Location location) {
            location.getLatitude();
            location.getLongitude();

            String myLocation = "Latitude = " + location.getLatitude() + " Longitude = " + location.getLongitude();
            latitudeLocation = String.valueOf(location.getLatitude());
            longitudeLocation = String.valueOf(location.getLongitude());

            txtLatitude = (TextView) findViewById(R.id.txtLatitude);
            txtLatitude.setText("Latitude:" + location.getLatitude());
            txtLongitude = (TextView) findViewById(R.id.txtLongitude);
            txtLongitude.setText("Longitude: "+ location.getLongitude());
            //I make a log to see the results
            Log.e("MY CURRENT LOCATION", myLocation);

        }

        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        public void onProviderEnabled(String s) {

        }

        public void onProviderDisabled(String s) {

        }
    }
>>>>>>> origin/master

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onSend(View view){
        String latitude = txtLatitude.getText().toString() ;
        String longitude = txtLongitude.getText().toString();
        String status  =   txtArduino.getText().toString();
        String plate =    txtPlate.getText().toString();

        sender backgroundSender = new sender(this);
        String type ="send";
        backgroundSender.execute(type, latitude,longitude,status,plate);

    }



    public class sender extends AsyncTask<String,Void,String> {
        private Context context;
        private int byGetOrPost = 0;

        public sender(Context context){
            this.context = context;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... arg0) {
            String type = arg0[0];
<<<<<<< HEAD
            String link = "http://192.168.1.8:81/Hackathon/hack4.php";
            String results="";
            String line="";
=======
            String link = "http://192.168.43.191:81/send_android.php";
>>>>>>> origin/master
            try{
                if(type.equals("send")) {
                    String lati = (String) arg0[1];
                    String longi = (String) arg0[2];
                    String status = (String) arg0[3];
                    String plate = (String) arg0[4];


                    URL url = new URL(link);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
<<<<<<< HEAD
                    String post_data = URLEncoder.encode("Latitude","UTF-8")+"="+ URLEncoder.encode(lati,"UTF-8")+"&"+
                            URLEncoder.encode("Longtitude","UTF-8")+"="+ URLEncoder.encode(longi,"UTF-8")+"&"+
                            URLEncoder.encode("Status","UTF-8")+"="+ URLEncoder.encode(status,"UTF-8")+"&"+
                            URLEncoder.encode("PlateNum","UTF-8")+"="+ URLEncoder.encode(plate,"UTF-8")+"&";
=======
                    String post_data = URLEncoder.encode("Lati","UTF-8")+"="+ URLEncoder.encode(lati,"UTF-8")+"&"+
                            URLEncoder.encode("Longi","UTF-8")+"="+ URLEncoder.encode(longi,"UTF-8")+"&"+
                            URLEncoder.encode("Status","UTF-8")+"="+ URLEncoder.encode(status,"UTF-8")+"&"+
                            URLEncoder.encode("Plate_num","UTF-8")+"="+ URLEncoder.encode(plate,"UTF-8")+"&";
>>>>>>> origin/master
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    outputStream.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
<<<<<<< HEAD

=======
                    String results="";
                    String line="";
>>>>>>> origin/master
                    while((line = bufferedReader.readLine()) != null){
                        results += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
<<<<<<< HEAD

=======
                    return results;
>>>>>>> origin/master
                }
            }catch(MalformedURLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
<<<<<<< HEAD
            return results;
        }
=======
        }99999999999999999999999999999999999999999999999
>>>>>>> origin/master
    }



}
