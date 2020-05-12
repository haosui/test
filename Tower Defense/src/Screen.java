import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class Screen extends JPanel implements Runnable {

    public static final int DELAY = 10;
    public static Image backGround ;
    public static Image Road;
    public static Image MenuBoard;
    public static Image Under;
    public static Image Menu;

    public static Enemy enemy = new Enemy();
    public static List<Enemy> enemies = new ArrayList<>();
    public static Button button1 = new Button(490,100,"res/AssetsKit_1/buttons/DefineButton2_80/1.png");
    public static Button button2 = new Button(490,200,"res/AssetsKit_1/buttons/DefineButton2_71/1.png");
    public static FortressMove fortressMove = new FortressMove();
    public static samllFortressMove samllFortressMove = new samllFortressMove();
    public static NormalFostress fortress = new NormalFostress() ;
    public static smallfostress smallfostress = new smallfostress();
    public static Bullet bullet = new Bullet();
    public static Player player = new Player();
    public static List<NormalFostress> fortressList = new ArrayList<>();
    public static List<smallfostress> smallfostresseslist = new ArrayList<>();
    public static Thread thread ;
    public static boolean isFirst = false;
    public static int flag = 0;
    public static int M_x = 460, M_y = 0;
    public static Rectangle but = new Rectangle(7,30,460-15,400);
    public static Rectangle butRoad1 = new Rectangle(7-10,30,460,50);
    public static Rectangle butRoad2 = new Rectangle(7-10,30,75, 215);
    public static Rectangle butRoad3 = new Rectangle(30,204-15,410, 26+30);
    public static Rectangle butRoad4 = new Rectangle(407-15,230-15,27+30, 130+30);
    public static Rectangle butRoad5 = new Rectangle(11,360-15,424+15, 26+30);
    public static Rectangle but2 = new Rectangle(490+7,100+30,49,36);
    public static Rectangle but3 = new Rectangle(490+7,200+30,49,30);
    public static Rectangle but4 = new Rectangle(216,386,200,50);

    public static Rectangle playagain_but = new Rectangle(492,370,50,50);
    public static Rectangle resume_but = new Rectangle(492,320,50,50);
    public static Rectangle pause_but = new Rectangle(492,270,50,50);




    public static Point point = new Point(-1,-1) ;
    public static Point point2 = new Point(-1000,-1000);
    public static Point DelPoint = new Point(-1000,-1000);
    public static List<Point> pointList = new ArrayList<>();
    public static int button_flag = 0;
    public  static Menu menu =new Menu();

    public Screen(Frame frame){

        frame.addMouseListener(new KeyEvent());
        frame.addMouseMotionListener(new KeyEvent());
        inIt_Image();
        setSize();
        inItThread();
        for( int i  = 0; i <= 5; i++)
        {  NormalEnemy n = new NormalEnemy();
            n.x+=300*(i+1);
            enemies.add(n);
        }

        for(int i=6;i<10;i++) {
            TankEnemy n = new TankEnemy();
            n.x+=300*(i+1);
            enemies.add(n);
        }
        SmallEnemy n = new SmallEnemy();
        n.x += 300*10;
        enemies.add(n);


    }


    public void doDrawing(Graphics g) throws InterruptedException


        {
            g.drawImage(Under, 0, 380, null);
            g.drawImage(backGround, 0, 0, null);
//        if(but.contains(point)){g.fillRect(0,0,460,400);}
            g.drawImage(Road, -10, 10, null);
            //enemy.draw(g);


            for (int i=0;i<enemies.size();i++) {
                if(!enemies.get(i).IsBoom)
                    enemies.get(i).draw(g);
            }

            int font_size = 20;
            Font f = new Font("Comic San MC",Font.BOLD,font_size);
            g.setFont(f);
            g.drawString("MONEY: "+ "\n" +player.money,460,14);

            Font h = new Font("new time roman",Font.ROMAN_BASELINE,font_size);
            g.setColor(Color.RED);
            g.drawString("HP: "+ player.HP,460,30);

            g.drawImage(MenuBoard, M_x, M_y, 138,449,null);


            menu.draw_button(g);
            menu.draw_lose(g);
            g.drawString("Your Points is: "+player.money, menu.point.x, menu.point.y);



            button1.draw(g);
            button2.draw(g);
            int n = fortressList.size();
            for(int i = 0; i < n; i++){
                // g.drawImage(fortressList.get(i).getImg(),pointList.get(i).x,pointList.get(i).y,null)
                if(fortressList.get(i).rectangle.contains(DelPoint)) {
                    fortressList.remove(i);
                    n = fortressList.size();
                    DelPoint.setLocation(new Point(-1000,-1000));
                    player.money+=5;
                }
                fortressList.get(i).draw(g);
                // bullet.set(pointList.get(i).x,pointList.get(i).y, enemy.x, enemy.y);
            }
            int m = smallfostresseslist.size();
            for(int i=0;i<m;i++) {
                if(smallfostresseslist.get(i).rectangle.contains(DelPoint)) {
                    smallfostresseslist.remove(i);
                    m= fortressList.size();
                    DelPoint.setLocation(new Point(-1000,-1000));
                    player.money+=5;
                }
                smallfostresseslist.get(i).draw(g);
            }
            //bullet.draw(g);
            //g.drawImage(bullet.getImg(),200,200,null);

            if(player.money >= 10) {

                if (but2.contains(point2)) {
                    fortressMove.draw(g);

                    isFirst = true;
                } else if (but.contains(point2)&& (!(butRoad5.contains(point2))) && (!(butRoad4.contains(point2))) && (!(butRoad1.contains(point2))) && (!(butRoad3.contains(point2))) && (!(butRoad2.contains(point2))) && isFirst) {
                    boolean check = true;
                    for(int i = 0; i < fortressList.size();i++){
                        if(fortressList.get(i).rectangleCheck.contains(point2)){
                            check = false;
                        }
                    }
                    if(check) {
                        pointList.add(new Point(point2.x - 30, point2.y - 50));
                        fortressList.add(new NormalFostress(point2.x - 7 - 75, point2.y - 30 - 75));
                        player.money -= 10;
                        isFirst = false;
                    }
                    isFirst = false;
                }

            }

            if(player.money >= 5) {

                if (but3.contains(point2)) {

                    samllFortressMove.draw(g);
                    isFirst = true;
                } else if (but.contains(point2)&& (!(butRoad5.contains(point2))) && (!(butRoad4.contains(point2))) && (!(butRoad1.contains(point2))) && (!(butRoad3.contains(point2))) && (!(butRoad2.contains(point2))) && isFirst) {
                    boolean check2 = true;
                    for(int i = 0; i < fortressList.size();i++){
                        if(smallfostresseslist.get(i).rectangleCheck.contains(point2)){
                            check2 = false;
                        }
                    }
                    if(check2) {
                        pointList.add(new Point(point2.x - 30, point2.y - 50));
                        smallfostresseslist.add(new smallfostress(point2.x - 75 - 7, point2.y - 105));
                        isFirst = false;
                        player.money -= 5;
                    }
                    isFirst = false;
                }

            }



//        fortress.draw(g);
//        else if (isFirst == false){
//            fortressF.setX(fortress.getX()+75);
//            fortressF.setY(fortress.getY()+75);
//            fortressF.draw(g);
//        };

        menu.draw2(g);
            //g.drawImage(menu.getImg(),(int) menu.x,(int) menu.y,null);

            g.dispose();
        }

    public void setSize(){
        Dimension d = new Dimension();
        d.width = 138+backGround.getWidth(null);
        d.height = 49+backGround.getHeight(null);
        setPreferredSize(d);
    }

    public void inIt_Image(){
        backGround = new ImageIcon("res/AssetsKit_1/shapes/53.png").getImage();
        Road = new ImageIcon("res/AssetsKit_1/shapes/266.png").getImage();
        Under = new ImageIcon("res/AssetsKit_1/shapes/14.png").getImage();
        MenuBoard = new ImageIcon("res/AssetsKit_1/shapes/60.jpg").getImage();
        Menu = new ImageIcon("idol.jpg").getImage();

    }

    public void inItThread() {
       thread = new Thread(this);
        thread.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        try {
            doDrawing(g);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void run() {
        boolean rungame = true;
        boolean runagain = false;

        boolean flag = true;
        while (flag){
          while (true) {
                if (but4.contains(point2) || runagain) {
                   // menu.mieru_menu(false);
                    menu.x = 1000;
                    menu.y =1000;
                    break;
                }
                System.out.println(point2.x + "    " + point2.y);

            }
            start();
        Sound.play(Sound.inGameSFX);

        while (player.getHP() > 0) {
            System.out.println(point2.x + "    " + point2.y);
                    if (pause_but.contains(point2))
                    {
                        rungame = false;

                    }
                    if (resume_but.contains(point2))

                    {
                       rungame = true;

                        System.out.println("chay");
                    }
                    if (playagain_but.contains(point2) )
                    {
                        runagain = true;
                        point2.x = 0;
                        point2.y =0;
                        start();


                    }
            if (rungame) {
                        for (int i = 0; i < fortressList.size(); i++) {
                            for (int j = 0; j < fortressList.get(i).bulletArrayList.size(); j++) {
                                //fortressList.get(i).bulletArrayList.get(j).move();
                                int f = 0;
                                while (f < enemies.size()) {

                                    if (j < fortressList.get(i).bulletArrayList.size() - 1) {
                                        check_collision_bulletvsenemy(fortressList.get(i).
                                                        bulletArrayList.get(j),
                                                enemies.get(f));
                                    }
        //                   if(mangEnermy.get(f).hp<=0) {player.money+=mangEnermy.get(f).price;  mangEnermy.remove(mangEnermy.get(f)); }
                                    if (enemies.get(f).hp <= 0 && enemies.get(f).isLive) {
                                        player.money += enemies.get(f).price;
                                        // enemies.remove(f);
                                        Sound.play(Sound.dieSFX);
                                    }
                                    f++;

                                }
                                // fortressList.get(i).bulletArrayList.get(j).move();
                            }
                            int k = select_target((NormalFostress) fortressList.get(i), enemies);
                            if (k != -1) {
                                check_collision_towervsenemy(fortressList.get(i), enemies.get(k));
                                //Sound.play(Sound.dieSFX);
                            }
                        }
                        for (int i = 0; i < fortressList.size(); i++) {

                            for (int j = 0; j < fortressList.get(i).bulletArrayList.size(); j++) {
                                if (j < fortressList.get(i).bulletArrayList.size() - 1 || j < fortressList.get(i).bulletArrayList.size()) {
                                    fortressList.get(i).bulletArrayList.get(j).move();

                                }
                            }
                        }

                        for (int i = 0; i < enemies.size(); i++) {
                            enemies.get(i).move();
                            if (enemies.get(i).hp > 0 && enemies.get(i).x < 0) {
                                //player.setHP(player.getHP() - enemies.get(i).dame);
                                player.setHP(player.getHP() - 100);
                                enemies.get(i).hp = 0;
                            }
                        }

                        repaint();
                        try {
                            Thread.sleep(DELAY);
                            } catch (InterruptedException e)
                                {
                                    e.printStackTrace();
                                }
                         }
        }
        menu.mieru_loser(true);
        menu.can_see_point(true);
        while (true)
        {
            repaint();
            if (playagain_but.contains(point2))
            {
                menu.mieru_loser(false);
                menu.can_see_point(false);
                runagain = true;
                break;
            }
        }
    }
    }

    public void start()
    {


        player.setHP(100);
        player.money = 100;
       fortressList.clear();
       enemies.clear();
        for( int i  = 0; i <= 5; i++)
        {  NormalEnemy n = new NormalEnemy();
            n.x+=300*(i+1);
            enemies.add(n);
        }

        for(int i=6;i<10;i++) {
            TankEnemy n = new TankEnemy();
            n.x+=300*(i+1);
            enemies.add(n);
        }
        SmallEnemy n = new SmallEnemy();
        n.x += 300*10;
        enemies.add(n);
    }

    public void  check_collision_towervsenemy(NormalFostress fortress, Enemy enemy)
    {
        fortress.rectangle = new Ellipse2D.Double(fortress.getX(),fortress.getY() ,fortress.getW(),fortress.getH());
        enemy.rectangleEnermy = new Rectangle((int)enemy.getX(), (int)enemy.getY(),30,20);
        if (fortress.rectangle.intersects(enemy.rectangleEnermy)  && enemy.hp > 0)
        {

            Bullet bullet = new Bullet();
            bullet.set(fortress,enemy);
            fortress.bulletArrayList.add(bullet);
        }
    }
    public  void check_collision_bulletvsenemy( Bullet bullet, Enemy enemy)
    {
        bullet.rectangleBullet =new Rectangle((int)bullet.getX(), (int)bullet.getY(),9,9);
        enemy.rectangleEnermy = new Rectangle((int)enemy.getX(), (int)enemy.getY(),30,20);
        if (bullet.rectangleBullet.intersects(enemy.rectangleEnermy))
        {

            bullet.live = false;
            enemy.hp-=1;
        }
    }
    public int select_target( NormalFostress fortress, List<Enemy> enemies)
    {
        fortress.rectangle = new Ellipse2D.Double(fortress.getX(),fortress.getY() ,fortress.getW(),fortress.getH());
        for (int i = 0; i < enemies.size() ; i++)
        {
            enemy = enemies.get(i);
            enemy.rectangleEnermy = new Rectangle((int) enemy.getX(), (int) enemy.getY(), 30, 20);

            if (fortress.rectangle.intersects(enemy.rectangleEnermy)  && enemy.hp > 0) {

                return i;
            }
        }

         return  -1;
    }
}
