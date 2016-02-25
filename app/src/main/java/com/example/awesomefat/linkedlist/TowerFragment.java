package com.example.awesomefat.linkedlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TowerFragment extends Fragment
{
    private Button theButton;
    private TowerFragment myself;
    private View towerView;
    private LinearLayout towerLayout;
    private ViewGroup towerGroup;
    private LayoutInflater theInflater;
    private int state = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        this.myself = this;
        this.towerGroup = container;
        this.theInflater = inflater;

        // Inflate the layout for this fragment
        this.towerView = inflater.inflate(R.layout.fragment_tower, container, false);
        this.towerLayout = (LinearLayout)this.towerView.findViewById(R.id.tower);

        this.theButton = (Button)this.towerView.findViewById(R.id.theButton);
        this.theButton.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
                myself.buttonClicked();

            }
        });
        return this.towerView;
    }

    public void setButtonText(int changeState)
    {
        this.state = changeState;
        if(this.state == 1)
        {
            theButton.setText("Pop");
        }
        else if (this.state ==2)
        {
            theButton.setText("Push");
        }
        else if(this.state == 3)
        {
            theButton.setText("Source");
        }
    }

    public String getButtonText()
    {
        return (String)theButton.getText();
    }

    public void addDisk(int size)
    {
        View disk = this.theInflater.inflate(R.layout.disk, this.towerGroup, false);
        TextView diskLabel = (TextView) disk.findViewById(R.id.diskLabel);
        String text = "";
        for(int i = 0; i < size; i++)
        {
            text += "_";
        }
        diskLabel.setText(text);
        this.towerLayout.removeView(this.theButton);
        this.towerLayout.addView(disk);
        this.towerLayout.addView(this.theButton);
    }

    public void buttonClicked()
    {
        System.out.println("it reaches here ****");

        if(this.state == 1)
        {
            System.out.println("And it gets here");
            TOHCore.toggleTowerButtons(this);
            TOHCore.diskSize = 3;

        }
        else if (this.state == 3)
        {

        }
        else if (this.state == 2)
        {
            addDisk(TOHCore.diskSize);
            TOHCore.resetTowerButtons();
        }
    }
}