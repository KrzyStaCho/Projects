import org.w3c.dom.events.Event;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game
{
    private EGame game;
    private int[][] Field = new int[4][4];
    Scanner scanner = new Scanner(System.in);
    public Game()
    {
        game = EGame.GAME_PREPARE;
        FillField();
        game = EGame.GAME_READY;
    }
    private void FillField()
    {
        Random random = new Random();
        ArrayList<String> list = new ArrayList<>();
        int i=0;
        for(int tab[] : Field)
        {
            int j=0;
            for(int field : tab)
            {
                int p;
                do {
                    p = random.nextInt(16)+1;
                }while(list.indexOf(Integer.toString(p))!=-1);
                list.add(Integer.toString(p));
                Field[i][j] = p;
                //System.out.println(p);
                j++;
            }
            i++;
        }
    }
    public EGame GetEGame()
    {
        return game;
    }
    public void Start()
    {
        if(game==EGame.GAME_READY)
        {
            game=EGame.GAME_PROGRESS;
            GameEvent();
        }
    }
    private void GameEvent()
    {
        while(game!=EGame.GAME_WIN)
        {
            DrawField();
            InputUserChoice();
            if(isWin())
            {
                game=EGame.GAME_WIN;
                System.out.println("Brawo! Udało ci się");
            }
        }
    }
    private void DrawField()
    {
        System.out.println("-----------------------");
        for(int tab[] : Field)
        {
            for(int field : tab)
            {
                if(field==16)
                {
                    System.out.print("|  X |");
                }
                else if(Integer.toString(field).length()==1)
                {
                    System.out.print("|  " + field + " |");
                }
                else
                {
                    System.out.print("| " + field + " |");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        System.out.print("Twój wybór: ");
    }
    private void InputUserChoice()
    {
        int UserChoice=0;
        try
        {
            UserChoice = scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.err.println("Nie podałes cyfry!");
            scanner.next();
            return;
        }
        catch (Exception e)
        {
            System.err.println("Error");
            return;
        }
        IntVector vector = GetXYEmptyField();
        if(vector.x!=3 && Field[vector.x+1][vector.y]==UserChoice)
        {
            Swap(vector,new IntVector(vector.x+1,vector.y),16,UserChoice);
        }
        else if(vector.x!=0 && Field[vector.x-1][vector.y]==UserChoice)
        {
            Swap(vector,new IntVector(vector.x-1,vector.y),16,UserChoice);
        }
        else if(vector.y!=3 && Field[vector.x][vector.y+1]==UserChoice)
        {
            Swap(vector,new IntVector(vector.x,vector.y+1),16,UserChoice);
        }
        else if(vector.y!=0 && Field[vector.x][vector.y-1]==UserChoice)
        {
            Swap(vector,new IntVector(vector.x,vector.y-1),16,UserChoice);
        }
        else
        {
            System.out.println("Podaj liczbę obok miejsca z napisem X, by zamienić je miejscami!");
        }
    }
    private IntVector GetXYEmptyField()
    {
        int i=0;
        int j=0;
        for(int tab[] : Field)
        {
            j=0;
            for(int x : tab)
            {
                if(x==16)
                {
                    return new IntVector(i,j);
                }
                j++;
            }
            i++;
        }
        return new IntVector(i,j);
    }
    private void Swap(IntVector empty, IntVector target, int x, int p)
    {
        IntVector tmp = empty;
        empty = target;
        target = tmp;
        Field[empty.x][empty.y]=x;
        Field[target.x][target.y]=p;
    }
    private boolean isWin()
    {
        int licznik=1;
        int good=0;
        for(int tab[] : Field)
        {
            for(int field : tab)
            {
                if(field==licznik)
                {
                    good++;
                }
                licznik++;
            }
        }
        if(good>=16)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
