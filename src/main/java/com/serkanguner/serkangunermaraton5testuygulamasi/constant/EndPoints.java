package com.serkanguner.serkangunermaraton5testuygulamasi.constant;

public class EndPoints {
    public static final String VERSION="/v1";
    //profiller:
    public static final String API="/api";
    public static final String DEV="/dev";
    public static final String TEST="/test";

    public static final String ROOT=API+VERSION;


    //entities:
    public static final String QUESTION="/question";
    public static final String ANSWER="/answer";



    //methods:
    public static final String SAVE = "/save";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String FINDALL = "/findall";
    public static final String FINDBYID = "/findbyid";

    public static final String SAVEQUESTIONANDANSWER = "/savequestionandanswer";
    public static final String FINDALLONLYQUESTION = "/findallonlyquestion";
    public static final String FINDQUESTIONANDANSWER = "/findallquestionandanswer";
    public static final String FINDQUESTIONRESULT = "/findquestionresult";
}
