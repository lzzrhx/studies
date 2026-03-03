package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.impl.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Utils {
    public static Film[] filmListToArr(List<Film> list){
        Film[] res = new Film[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
