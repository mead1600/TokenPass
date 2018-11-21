import java.util.Arrays;

public class TokenPass {
    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount)
    {
        this.board = new int[playerCount];
        for(int i = 0; i < playerCount; i++)
        {
            this.board[i] = (int)(Math.random()*10)+1;
        }
        this.currentPlayer = (int)(Math.random()*playerCount);
    }

    public void distributeCurrentPlayerTokens()
    {
        int position = this.currentPlayer;
        while(this.board[currentPlayer] > 0)
        {
            if(position > this.board.length-1)
            {
                position = 0;
            }
            this.board[position]++;
            position++;
            this.board[currentPlayer]--;
        }
    }

    public void nextPlayer()
    {
        this.currentPlayer = this.currentPlayer + 1;
        if(this.currentPlayer > this.board.length)
        {
            this.currentPlayer = 0;
        }
    }

    public int gameOver()
    {
        int val = -1;
        for(int i = 0; i < this.board.length; i++)
        {
            if(this.board[i] == 0){
                val = i;
            }
            else
            {
                val = -1;
            }
        }
        return val;
    }

    public void printBoard()
    {
        String[] table = new String[this.board.length];
        for(int i = 0; i < this.board.length; i++)
        {
            table[i] = "Player " + i +": " + this.board[i];
        }
        System.out.println(Arrays.toString(table));
    }
}
