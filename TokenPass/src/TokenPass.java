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
        while(this.board[currentPlayer-1] > 0)
        {
            if(position > this.board.length-1)
            {
                position = 0;
            }
            this.board[position]++;
            this.board[currentPlayer-1]--;
        }
    }
}
