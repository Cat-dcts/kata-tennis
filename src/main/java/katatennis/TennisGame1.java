package katatennis;

public class TennisGame1 implements TennisGame {
    
    private int pointPlayer1;
    private int pointPlayer2;
    private String player1Name;
    private String player2Name;
    
    protected static final String[] scores = {"Love","Fifteen","Thirty","Fourty"};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            pointPlayer1 += 1;
        else
            pointPlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (pointPlayer1==pointPlayer2)
        {
            switch (pointPlayer1)
            {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
                
            }
        }
        else if (pointPlayer1>=4 || pointPlayer2>=4)
        {
            int minusResult = pointPlayer1-pointPlayer2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = pointPlayer1;
                else { score+="-"; tempScore = pointPlayer2;}
                switch(tempScore)
                {
                    case 0:
                        score+=scores[0];
                        break;
                    case 1:
                        score+=scores[1];
                        break;
                    case 2:
                        score+=scores[2];
                        break;
                    case 3:
                        score+=scores[3];
                        break;
                    default:
                    	break;
                }
            }
        }
        return score;
    }
}