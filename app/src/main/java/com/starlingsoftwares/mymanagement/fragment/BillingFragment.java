package com.starlingsoftwares.mymanagement.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.starlingsoftwares.mymanagement.R;
import com.starlingsoftwares.mymanagement.activity.HomeActivity;
import com.starlingsoftwares.mymanagement.adapter.EntryAdapter;
import com.starlingsoftwares.mymanagement.adapter.HomeAdapter;
import com.starlingsoftwares.mymanagement.model.Entry;
import com.starlingsoftwares.mymanagement.model.Home;

import java.util.ArrayList;

public class BillingFragment extends Fragment implements View.OnClickListener {
    Spinner spinner_billing_batchname;
    LinearLayout a, b, one, two, three, four, five, six, seven, eight, nine, zero, zerozero, zerozerozero, enter, backspace;
    TextView txtBillingJoinHarup, txtBillingPrice, txt_totalvalue;
    String join = "";
    String jj, pp = "";
    int count = 0, oo;
    int serial = 0;
    int flag = 1;
    RecyclerView recycler_entry;
    EditText et_jodiharup, et_price;
    ArrayList<Entry> entryArrayList;
    EntryAdapter entryAdapter;
    int total;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_billing, container, false);
        entryArrayList = new ArrayList<>();
        String[] city_listt = new String[5];
        city_listt[0] = "Select Batch";
        city_listt[1] = "Gurgaon";
        city_listt[2] = "Faridabad";
        city_listt[3] = "Gaziabad";
        city_listt[4] = "Gali";
        spinner_billing_batchname = v.findViewById(R.id.spinner_billing_batchname);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, city_listt);
        spinner_billing_batchname.setAdapter(adapter);

        spinner_billing_batchname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                entryArrayList.clear();
                Log.i("data", jj + pp + serial);
                recycler_entry.setLayoutManager(new LinearLayoutManager(getActivity()));
                entryAdapter = new EntryAdapter(entryArrayList, getActivity());
                recycler_entry.setAdapter(entryAdapter);
                entryAdapter.notifyDataSetChanged();
                serial = 0;
                total = 0;
                txt_totalvalue.setText("Total");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        a = v.findViewById(R.id.a);
        b = v.findViewById(R.id.b);
        one = v.findViewById(R.id.one);
        two = v.findViewById(R.id.two);
        three = v.findViewById(R.id.three);
        four = v.findViewById(R.id.four);
        five = v.findViewById(R.id.five);
        six = v.findViewById(R.id.six);
        seven = v.findViewById(R.id.seven);
        eight = v.findViewById(R.id.eight);
        nine = v.findViewById(R.id.nine);
        zero = v.findViewById(R.id.zero);
        zerozero = v.findViewById(R.id.zerozero);
        zerozerozero = v.findViewById(R.id.zerozerozero);
        enter = v.findViewById(R.id.enter);
        backspace = v.findViewById(R.id.backspace);
        et_jodiharup = v.findViewById(R.id.et_jodiharup);
        et_price = v.findViewById(R.id.et_price);
        txt_totalvalue = v.findViewById(R.id.txt_totalvalue);


        recycler_entry = v.findViewById(R.id.recycler_entry);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        zerozero.setOnClickListener(this);
        zerozerozero.setOnClickListener(this);
        backspace.setOnClickListener(this);
        enter.setOnClickListener(this);
        if (count < 2) {
            join = "";
        }
        et_price.setFocusable(false);
        et_jodiharup.setFocusable(false);

        et_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_price.setFocusable(true);
                et_jodiharup.setFocusable(false);

            }
        });
        et_jodiharup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_price.setFocusable(false);

                et_jodiharup.setFocusable(true);

            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.a:

                join = join + "A";
                if (count == 2) {
                    join = "" + "A";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;
                break;
            case R.id.b:

                join = join + "B";
                if (count == 2) {
                    join = "" + "B";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;

                break;

            case R.id.one:
                join = join + "1";
                if (count == 2) {
                    join = "" + "1";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;

                break;

            case R.id.two:
                join = join + "2";
                if (count == 2) {
                    join = "" + "2";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;

                break;
            case R.id.three:

                join = join + "3";
                if (count == 2) {
                    join = "" + "3";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;
                break;
            case R.id.four:

                join = join + "4";
                if (count == 2) {
                    join = "" + "4";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;
                break;
            case R.id.five:

                join = join + "5";
                if (count == 2) {
                    join = "" + "5";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;
                break;
            case R.id.six:
                join = join + "6";
                if (count == 2) {
                    join = "" + "6";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;
                break;
            case R.id.seven:
                join = join + "7";
                if (count == 2) {
                    join = "" + "7";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;

                break;
            case R.id.eight:
                join = join + "8";
                if (count == 2) {
                    join = "" + "8";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;
                break;
            case R.id.nine:
                join = join + "9";
                if (count == 2) {
                    join = "" + "9";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;

                break;
            case R.id.zero:
                join = join + "0";
                if (count == 2) {
                    join = "" + "0";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;

                break;
            case R.id.zerozero:
                join = join + "00";
                if (count == 2) {
                    join = "" + "00";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;

                break;
            case R.id.zerozerozero:

                join = join + "0000";
                if (count == 2) {
                    join = "" + "0000";

                }
                if (count < 2) {
                    if (join.length() < 3) {
                        et_jodiharup.setText(join);
                    } else {
                        join = "";
                    }
                } else {
                    et_price.setText(join);
                }
                count++;
                break;

            case R.id.backspace:
                if (et_jodiharup.isFocusable()) {

                    et_jodiharup.setText("");
                    count = 0;
                    join = "";

                } else {
                    et_price.setText("");
                    join = "";

                }

                break;
            case R.id.enter:

                jj = et_jodiharup.getText().toString();
                pp = et_price.getText().toString();
                if (jj.equals("") || pp.equals("")) {
                    Toast.makeText(getActivity(), "Empty Field", Toast.LENGTH_SHORT).show();
                } else if (pp.contains("A") || pp.contains("B") || pp.contains("AB") || pp.contains("BA") || pp.contains("AA") || pp.contains("BB")) {
                    Toast.makeText(getActivity(), "Only number will be entered", Toast.LENGTH_SHORT).show();

                } else {
                    serial++;
                    entryArrayList.add(new Entry(jj, pp, serial));
                    Log.i("data", jj + pp + serial);
                    recycler_entry.setLayoutManager(new LinearLayoutManager(getActivity()));
                    entryAdapter = new EntryAdapter(entryArrayList, getActivity());
                    recycler_entry.setAdapter(entryAdapter);
                    entryAdapter.notifyDataSetChanged();
                }
                if (serial == 1) {
                    if (pp.equals("")) {
                        Toast.makeText(getActivity(), "Empty Field", Toast.LENGTH_SHORT).show();
                    } else if (pp.contains("A") || pp.contains("B") || pp.contains("AB") || pp.contains("BA") || pp.contains("AA") || pp.contains("BB")) {
                        Toast.makeText(getActivity(), "Only number will be entered", Toast.LENGTH_SHORT).show();

                    } else {
                        total = Integer.parseInt(pp);
                    }
                } else {
                    if (pp.equals("")) {
                        Toast.makeText(getActivity(), "Empty Field", Toast.LENGTH_SHORT).show();
                    } else if (pp.contains("A") || pp.contains("B") || pp.contains("AB") || pp.contains("BA") || pp.contains("AA") || pp.contains("BB")) {
                        Toast.makeText(getActivity(), "Only number will be entered", Toast.LENGTH_SHORT).show();

                    } else {
                        total = total + Integer.parseInt(pp);
                    }
                }

                txt_totalvalue.setText("Total  \n" + total);
                et_price.setText("");
                et_jodiharup.setText("");
                join = "";
                count = 0;
                break;
        }
    }
}
