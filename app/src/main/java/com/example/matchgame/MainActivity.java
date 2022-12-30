package com.example.matchgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//assets used
// ------------------------------------------------------
//art assets  - https://felipegrebogeart.itch.io/spell-icons
//sound assets  - https://www.soundboard.com/sb/sound/234682

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ImageView r1c1, r1c2, r1c3, r2c1, r2c2, r2c3, r3c1, r3c2, r3c3;
    TextView timer;
    Integer[] memoryArray = {11, 12, 13, 14, 15, 21, 22, 23, 24};
    ImageView restart;
    int image1, image2, image3, image4, image5, image6, image7, image8, image9;

    int pair = 1;
    int points = 0;
    int card1, card2;
    int clicked1, clicked2;
    int cardNum =1;
    int ticket = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = (TextView) findViewById(R.id.timerViewText);
        restart = (ImageView) findViewById(R.id.restartImage);
        r1c1 = (ImageView) findViewById(R.id.r1c1);
        r1c2 = (ImageView) findViewById(R.id.r1c2);
        r1c3 = (ImageView) findViewById(R.id.r1c3);
        r2c1 = (ImageView) findViewById(R.id.r2c1);
        r2c2 = (ImageView) findViewById(R.id.r2c2);
        r2c3 = (ImageView) findViewById(R.id.r2c3);
        r3c1 = (ImageView) findViewById(R.id.r3c1);
        r3c2 = (ImageView) findViewById(R.id.r3c2);
        r3c3 = (ImageView) findViewById(R.id.r3c3);

        r1c1.setTag("0");
        r1c2.setTag("1");
        r1c3.setTag("2");
        r2c1.setTag("3");
        r2c2.setTag("4");
        r2c3.setTag("5");
        r3c1.setTag("6");
        r3c2.setTag("7");
        r3c3.setTag("8");


        flipCardImages();
        Collections.shuffle(Arrays.asList(memoryArray));

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        r1c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int card = Integer.parseInt((String) view.getTag());
                makeCard(r1c1, card);


            }
        });
        r1c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int card = Integer.parseInt((String) view.getTag());
                makeCard(r1c2, card);

            }
        });
        r1c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int card = Integer.parseInt((String) view.getTag());
                makeCard(r1c3, card);

            }
        });
        r2c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int card = Integer.parseInt((String) view.getTag());
                makeCard(r2c1, card);

            }
        });
        r2c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int card = Integer.parseInt((String) view.getTag());
                makeCard(r2c2, card);

            }
        });
        r2c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int card = Integer.parseInt((String) view.getTag());
                makeCard(r2c3, card);

            }
        });
        r3c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int card = Integer.parseInt((String) view.getTag());
                makeCard(r3c1, card);

            }
        });
        r3c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int card = Integer.parseInt((String) view.getTag());
                makeCard(r3c2, card);

            }
        });
        r3c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int card = Integer.parseInt((String) view.getTag());
                makeCard(r3c3, card);


            }
        });

    }

    private void makeCard(ImageView imageView, int card) {
        Log.e("Test","makeCard");
        if (memoryArray[card] == 11) {
            Log.e("Test","[card] == 11");
            imageView.setImageResource(image1);
        } else if (memoryArray[card] == 12) {
            imageView.setImageResource(image2);
        } else if (memoryArray[card] == 13) {
            imageView.setImageResource(image3);
        } else if (memoryArray[card] == 14) {
            imageView.setImageResource(image4);
        }
        else if (memoryArray[card] == 15) {
            imageView.setImageResource(image5);
        }
        else if (memoryArray[card] == 21) {
            imageView.setImageResource(image6);
        } else if (memoryArray[card] == 22) {
            imageView.setImageResource(image7);
        } else if (memoryArray[card] == 23) {
            imageView.setImageResource(image8);
        } else if (memoryArray[card] == 24) {
            imageView.setImageResource(image9);
        }
        Log.e("Test","card num");
        if (cardNum == 1) {
            Log.e("Test","cardNum == 1");
            card1 = memoryArray[card];
            if (card1 > 20) {
                card1 = card1 - 10;
            }
            cardNum = 2;
            clicked1 = card;

            imageView.setEnabled(false);
        } else if (cardNum == 2) {
            Log.e("Test","cardNum == 2");
            card2 = memoryArray[card];
            if (card2 > 20) {
                card2 = card2 - 10;
            }
            cardNum = 1;
            clicked2 = card;
            Log.e("Test","setEnabled(false)");


            r1c1.setEnabled(false);
            r1c2.setEnabled(false);
            r1c3.setEnabled(false);
            r2c1.setEnabled(false);
            r2c2.setEnabled(false);
            r2c3.setEnabled(false);
            r3c1.setEnabled(false);
            r3c2.setEnabled(false);
            r3c3.setEnabled(false);

            Handler handler = new Handler();
            Log.e("Test","Handler");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Log.e("Test","calculate");
                    calculate();
                }
            }, 1000);

        }
    }

    private void calculate() {
        if (card1 == card2) {
            if (clicked1 == 0) {
                r1c1.setVisibility(View.INVISIBLE);
            } else if (clicked1 == 1) {
                r1c2.setVisibility(View.INVISIBLE);
            } else if (clicked1 == 2) {
                r1c3.setVisibility(View.INVISIBLE);
            } else if (clicked1 == 3) {
                r2c1.setVisibility(View.INVISIBLE);
            } else if (clicked1 == 4) {
                r2c2.setVisibility(View.INVISIBLE);
            } else if (clicked1 == 5) {
                r2c3.setVisibility(View.INVISIBLE);
            } else if (clicked1 == 6) {
                r3c1.setVisibility(View.INVISIBLE);
            } else if (clicked1 == 7) {
                r3c2.setVisibility(View.INVISIBLE);
            } else if (clicked1 == 8) {
                r3c3.setVisibility(View.INVISIBLE);
            }

            if (clicked2 == 0) {
                r1c1.setVisibility(View.INVISIBLE);
            } else if (clicked2 == 1) {
                r1c2.setVisibility(View.INVISIBLE);
            } else if (clicked2 == 2) {
                r1c3.setVisibility(View.INVISIBLE);
            } else if (clicked2 == 3) {
                r2c1.setVisibility(View.INVISIBLE);
            } else if (clicked2 == 4) {
                r2c2.setVisibility(View.INVISIBLE);
            } else if (clicked2 == 5) {
                r2c3.setVisibility(View.INVISIBLE);
            } else if (clicked2 == 6) {
                r3c1.setVisibility(View.INVISIBLE);
            } else if (clicked2 == 7) {
                r3c2.setVisibility(View.INVISIBLE);
            } else if (clicked2 == 8) {
                r3c3.setVisibility(View.INVISIBLE);
            }

            if (pair == 1) {
                Log.e("Test","pair == 1 Change");
                ticket++;
                Log.e("Test","ticket pair == 1 >>>" + ticket);
                points++;
                timer.setText("Points "+ points);
            } else if (pair == 2) {
                Log.e("Test","pair == 2 Change");
                ticket++;
                Log.e("Test","ticket pair == 2 >>>" + ticket);
                points++;
                timer.setText("Points "+ points);
            }
        } else {
            Log.e("Test","Question Change");
            r1c1.setImageResource(R.drawable.question);
            r1c2.setImageResource(R.drawable.question);
            r1c3.setImageResource(R.drawable.question);
            r2c1.setImageResource(R.drawable.question);
            r2c2.setImageResource(R.drawable.question);
            r2c3.setImageResource(R.drawable.question);
            r3c1.setImageResource(R.drawable.question);
            r3c2.setImageResource(R.drawable.question);
            r3c3.setImageResource(R.drawable.question);

            if (pair ==1 ) {
                pair =2;
            } else if (pair ==2 ) {
                pair =1;
            }
        }
        r1c1.setEnabled(true);
        r1c2.setEnabled(true);
        r1c3.setEnabled(true);
        r2c1.setEnabled(true);
        r2c2.setEnabled(true);
        r2c3.setEnabled(true);
        r3c1.setEnabled(true);
        r3c2.setEnabled(true);
        r3c3.setEnabled(true);

        checkPaired();


    }
    private void checkPaired() {
        if (ticket == 4) {
            final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.final_fantasy_fanfare);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);

            alertDialogBuilder
                    .setMessage("YOU WIN!!!!!!!\n YOUR SCORE IS: " + points)
                    .setCancelable(false)
                    .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                            mediaPlayer.stop();
                        }
                    })
                    .setNegativeButton("EXIT GAME", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                            mediaPlayer.stop();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

    }

    private void flipCardImages() {
        image1 = R.drawable.fireball;
        image2 = R.drawable.firestorm;
        image3 = R.drawable.hailstorm;
        image4 = R.drawable.iceshield;
        image5 = R.drawable.rockshatter;
        image6 = R.drawable.fireball;
        image7 = R.drawable.firestorm;
        image8 = R.drawable.hailstorm;
        image9 = R.drawable.iceshield;
    }
}