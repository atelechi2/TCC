
 
// Pin 13 has an LED connected on most Arduino boards.
// give it a name:

int tempoDelay = 100;//10000;

//Variaveis Feedback do Servidor
int feedbackLampada1 = 1;
int feedbackLampada2 = 2;
int feedbackLampada3 = 3;

//Variaveis de nsor
int led8 = 8;
int led9 = 9;
int led10 = 10;

//Comando do Servidor
int Lampada1 = 13;
int Lampada2 = 12;
int Lampada3= 11;




int tempoLigado =0;
int tempoDesligado = 500;
char tecla; 

// the setup routine runs once when you press reset:
void setup() 
  {                
  // initialize the digital pin as an output.
  pinMode(Lampada3, OUTPUT);   
  pinMode(Lampada2, OUTPUT);   
  pinMode(Lampada1, OUTPUT);     
    
  pinMode(feedbackLampada1, OUTPUT);      
  pinMode(feedbackLampada2, OUTPUT);    
  pinMode(feedbackLampada3, OUTPUT);     
  Serial.begin(9600);  
  }
  
// the loop routine runs over and over again forever:
void loop() 
  {
   //Serial.write(1);
   tecla = NULL;
   int variacao;
  //getTecla();
  if(Serial.available()>0)
    {
    tecla = Serial.read(); 
    }



//**********************************************************Lampada 1********************************************************************************    
  if(tecla == 81)//Q Desliga 
    {
     digitalWrite(Lampada1, LOW);   // turn the LED on (HIGH is the voltage level)
     int ldr1=0;
  //   delay(100);
  //   ldr1 = analogRead(A1);  
     if(ldr1 >= 400)
       {
       for (int tempo = 0; tempo <= tempoDelay; tempo++) 
         {
          Serial.println(1);      
          }
       }
     else  
       {
       for (int tempo = 0; tempo <= tempoDelay; tempo++) 
          {
          Serial.println(2);      
          }
       }
    }
  if(tecla == 87)//W Liga
    {
    digitalWrite(Lampada1, HIGH);   // turn the LED on (HIGH is the voltage level)
 //    delay(100);    
     int ldr1=0;
 //    ldr1 = analogRead(A1);  
     if(ldr1 >= 400)
       {
        for (int tempo = 0; tempo <= tempoDelay; tempo++) 
          {      
          Serial.println(1);      
          }
       }
     else  
       {
       for (int tempo = 0; tempo <= tempoDelay; tempo++) 
          {
          Serial.println(2);      
          }
       }
    }
    
    
    
    
//**********************************************************Lampada 2********************************************************************************    
  if(tecla == 65)//A Desliga
    {
     digitalWrite(Lampada2, LOW);   // turn the LED on (HIGH is the voltage level)
 //    delay(100);     
     int ldr1=0;
  //   ldr1 = analogRead(A2);  
     if(ldr1 >= 400)
       {
       for (int tempo = 0; tempo <= tempoDelay; tempo++) 
         {
          Serial.println(4);      
          }
       }
     else  
       {
       for (int tempo = 0; tempo <= tempoDelay; tempo++) 
          {
          Serial.println(3);      
          }
       }
    }
  if(tecla == 83)//S Liga
    {
     digitalWrite(Lampada2, HIGH);   // turn the LED on (HIGH is the voltage level)
//     delay(100);     
      int ldr1=0;
 //    ldr1 = analogRead(A2);  
     if(ldr1 >= 400)
       {
       for (int tempo = 0; tempo <= tempoDelay; tempo++) 
         {
          Serial.println(4);      
          }
       }
     else  
       {
       for (int tempo = 0; tempo <= tempoDelay; tempo++) 
          {
          Serial.println(3);      
          }
       }
    }
    
    
    
//**********************************************************Lampada 3********************************************************************************        
  if(tecla == 88)//X Desliga
    {
     digitalWrite(Lampada3, LOW);   // turn the LED on (HIGH is the voltage level)
      int ldr1=0;      
     for (int tempo1 = 0; tempo1 <= 100; tempo1++){ldr1 = analogRead(A3);}        
     if(ldr1 >= 400)
       {
       for (int tempo = 0; tempo <= tempoDelay; tempo++) 
         {
          Serial.println(6);      
          }
       }
     else  
       {
       for (int tempo = 0; tempo <= tempoDelay; tempo++) 
          {
          Serial.println(5);      
          }
       } 
    }
  if(tecla == 89)//Y Liga 
    {  

     digitalWrite(Lampada3, HIGH);   // turn the LED on (HIGH is the voltage level)
     int ldr1=0; 
     for (int tempo1 = 0; tempo1 <= 100; tempo1++){ldr1 = analogRead(A3);}            
     if(ldr1 >= 400)
       {
       for (int tempo = 0; tempo <= tempoDelay; tempo++) 
         {
          Serial.println(6);      
          }
       }
     else  
       {
       for (int tempo = 0; tempo <= tempoDelay; tempo++) 
          {
          Serial.println(5);      
          }
       } 
    }
    
 }
  
