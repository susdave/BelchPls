#include <SoftwareSerial.h>
const int RX_PIN = 0;
const int TX_PIN = 1;
 SoftwareSerial btserial(RX_PIN,TX_PIN);
 
void setup() {
  
  btserial.begin(38400);
  pinMode(13, OUTPUT);
  pinMode(A0, INPUT);
  digitalWrite(13, HIGH);
}

void loop() {
  
  int val = analogRead(A0);
  if(val<=140)
  {
    btserial.print('#');
    btserial.print(val);
    btserial.print("Poor");
    btserial.print("");
    btserial.println();
    delay(3000);
  }
  else if(val>140||val<=280)
  {
    btserial.print('#');
    btserial.print(val);
    btserial.print("Fair");
    btserial.print('~');
    btserial.println();
    delay(3000);
  }
  else if(val>280||val<=420)
  {
    btserial.print('#');
    btserial.print(val);
    btserial.print("Good");
    btserial.print('~');
    btserial.println();
    delay(3000);
  }
  else if(val>420||val<=560)
  {
    btserial.print('#');
    btserial.print(val);
    btserial.print("Very Good");
    btserial.print('~');
    btserial.println();
    delay(3000);
  }
  else if(val>560||val<=700)
  {
    btserial.print('#');
    btserial.print(val);
    btserial.print("Excellent");
    btserial.print('~');
    btserial.println();
    delay(3000);
   } 
  
}
 
