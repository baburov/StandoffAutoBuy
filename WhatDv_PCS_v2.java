//изм01
int stickCount = 3;
int stickSize = 52;


var stickL = Point.get(1479,581);
var stickR = Point.get(1479 + stickCount * stickSize,602); 

var buy = Point.get(2240,569);


var confirm = Point.get(1197,748);

var upd = Point.get(1449,459);

int slotH = 144;

int slotA = 3;

int updColor = 6381138;

startScreenCapture(2);

sleep(5);

long kdtime = Time.getMillis();


long slpS = 1000;

Point lp = Point.get();    
Point rp = Point.get();
lp.x = stickL.x;
rp.x = stickR.x;
for (;;)
{ 
     for(int q = 0; q < slotA; q++)
     {
          lp.y = stickL.y + (q * slotH);
          rp.y = stickR.y + (q * slotH);
          if(getContoursCount (lp, rp) > 2 && getColor(buy.x, buy.y + (slotH * q)) < 11077777)
          {
               click(buy.x, buy.y + (slotH * q));                                     
               sleep(25);
               clickRand(confirm, 0);
               sleep(100);
               clickRand(confirm, 0);
               sleep(100);
               log("buy › "+Time.getTime());
               break;
          }
          if ((((Time.getMillis() - kdtime) / slpS) % 2 == 0) && getColor(buy.x, buy.y + (slotH * q)) > 14000000)
          {
               clickRand(upd, 0);
               sleep(100);
               clickRand(upd, 0);
               sleep(300)

               break;
          }
     }
}
