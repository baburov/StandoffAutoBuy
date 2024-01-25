
int stickCount = 3;
int stickSize = 52;

var error = Point.get(1357, 752);
int errorColor = 9992742;

var stickL = Point.get(1475,581);
var stickR = Point.get(1475 + (5 - stickCount) * stickSize,602); 

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
int itt = 0;

for (;;)
{ 
    for(int q = 0; q < slotA; q++)
    {
        Point lp = Point.get();    
        Point rp = Point.get();
        lp.x = stickL.x;
        lp.y = stickL.y + (q * slotH);
        rp.x = stickR.x;
        rp.y = stickR.y + (q * slotH);
            
        if(getContoursCount (lp, rp) > 2 && getColor(buy.x, buy.y + (slotH * q)) < 11077777)
        {
            for (int x = 0; x < 2; x++){
                click(buy.x, buy.y + (slotH * q));  
                sleep(10);
            }
            sleep(15);
            for (int x = 0; x < 2; x++){
                clickRand(confirm, 0);
                sleep(10);
            }
            sleep(150);
            if (getColor(error.x, error.y) <= errorColor + 1000)
            {
                clickRand(confirm, 0);
                sleep(120);
                log("error buy › "+Time.getTime());
            }
            else
                log("buy › "+Time.getTime());
        }
        if ((((Time.getMillis() - kdtime) / slpS) % 10 == (itt++ % 10)) && getColor(buy.x, buy.y + (slotH * q)) > 14000000)
        {
            clickRand(upd, 0);
            sleep(100);
            clickRand(upd, 0);
            sleep(300);

            break;
        }
    }
}
