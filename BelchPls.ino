#include <SoftwareSerial.h>
const int RX_PIN = 0;
const int TX_PIN = 1;
 SoftwareSerial btserial(RX_PIN,TX_PIN);
 
void setup() {
  
  btserial.begin(38400);
  pinMode(13, OUTPUT);
  digitalWrite(13, HIGH);
}

void loop() {
  
  int val = analogRead(A0);
  if(val<=100)
  {
    
    btserial.print(val);
    btserial.print(" Poor ");
    btserial.print(" Smoke:");
    btserial.print(analogRead(A1));
   
    btserial.println();
    delay(3000);
  }
  else if(val>100&&val<=200)
  {
    
    btserial.print(val);
    btserial.print("Fair");
    btserial.print(" Smoke:");
    btserial.print(analogRead(A1));
    btserial.println();
    delay(3000);   
  }
  else if(val>200&&val<=300)
  {
    
    btserial.print(val);
    btserial.print("Good");
    btserial.print(" Smoke:");
    btserial.print(analogRead(A1));
    btserial.println();
    delay(3000);
  }
  else if(val>300&&val<=400)
  {
    
    btserial.print(val);
    btserial.print("Very Good");
    btserial.print(" Smoke:");
    btserial.print(analogRead(A1));
    btserial.println();
    delay(3000);
  }
  else if(val>400)
  {
    
    btserial.print(val);
    btserial.print("Excellent");
    btserial.print(" Smoke:");
    btserial.print(analogRead(A1));
    btserial.println();
    delay(3000);
   } 
  
}
 
