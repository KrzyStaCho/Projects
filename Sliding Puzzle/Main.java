public class Main
{
    public static void main(String[] args)
    {
        Manager manager = new Manager();
        Game game = new Game();
        do {
        }while(game.GetEGame()!=EGame.GAME_READY);
        game.Start();
    }
}
