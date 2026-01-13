# Format Description:
## 1. Strings within double square brackets are paradigm category names ([[e.g. Noun_m]]).
### 2. The lines immediately following the paradigm categoy names are the feature structures corresponding to the core word forms, in a common word order, associated with that paradigm category. These are common to all specific paradigms as listed in .p files
### 3. The lines separated from the above by a blank line are the descriptions for specific paradigms in that category (e.g. [[Noun_m_e]]). These lines mainly describe additional paradigm sub categories. The first line here gives the sub-category name, also corresponding to a separate .p file. They share the core feature structure of the category, but have one or more additional features. The XXX represents the place where the lemma give below will be substituted while generating to Hindi. These have the some unstructured comments and one or two Devanagari strings. The first of these is the generated Hindi lemma. The second is the generated form to Hindi as mentioned. The 'Steps ...' lines can be ignored. The sub-categories are also seperated by a blank line, but their names are not in double square brackets.
## 4. The content at the end, beginning with [[[TAM Dict from B_M_M (SL) to Hindi (TL)]]] can be ignored for now.


\[\[Noun\_m\]\]

\<fs af='XX,n,m,sg,3,d,0,0'\>  
\> घर  
\>\> घर

\<fs af='XX,n,m,pl,3,d,0,0'\>  
\> घर  
\>\> घर

\<fs af='XX,n,m,sg,3,o,0,0'\>  
\> घर  
\>\> घर

\<fs af='XX,n,m,pl,3,o,0,0'\>  
\> घर  
\>\> घरों

\[\[Noun\_m\_e\]\]

\<fs af='XX,n,m,sg,3,d,0,0' emph='y'\>   
\#Root will be substituted  
\>घर  
\#Step1= Seperate out emph='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>घर\_ही

\<fs af='XX,n,m,pl,3,d,0,0' emph='y'\>  
\#Root will be substituted  
\>घर  
\#Step1= Seperate out emph='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>घर\_ही

\<fs af='XX,n,m,sg,3,o,0,0' emph='y'\>  
\#Root will be substituted  
\>घर  
\#Step1= Seperate out emph='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>घर\_ही

\<fs af='XX,n,m,pl,3,o,0,0' emph='y'\>  
\#Root will be substituted  
\>घर  
\#Step1= Seperate out emph='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>घरों\_ही

\[\[Noun\_m\_e1\]\]

\<fs af='XX,n,m,sg,3,d,0,0' emph1='y'\>   
\#Root will be substituted  
\>घर  
\#Step1= Seperate out emph1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>घर\_भी

\<fs af='XX,n,m,pl,3,d,0,0' emph1='y'\>  
\#Root will be substituted  
\>घर  
\#Step1= Seperate out emph1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>घर\_भी

\<fs af='XX,n,m,sg,3,o,0,0' emph1='y'\>  
\#Root will be substituted  
\>घर  
\#Step1= Seperate out emph1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>घर\_भी

\<fs af='XX,n,m,pl,3,o,0,0' emph1='y'\>  
\#Root will be substituted  
\>घर  
\#Step1= Seperate out emph1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>घरों\_भी

\[\[Noun\_f\]\]

\<fs af='XX,n,f,sg,3,d,0,0'\>   
\#Root will be substituted  
\>रात  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>रात

\<fs af='XX,n,f,pl,3,d,0,0'\>  
\#Root will be substituted  
\>रात  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>रातें

\<fs af='XX,n,f,sg,3,o,0,0'\>  
\#Root will be substituted  
\>रात  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>रात

\<fs af='XX,n,f,pl,3,o,0,0'\>  
\#Root will be substituted  
\>रात  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>रातों

\[\[Noun\_f\_e\]\]

\<fs af='XX,n,f,sg,3,d,0,0' emph='y'\>   
\#Root will be substituted  
\>रात  
\#Step1= Seperate out emph='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>रात\_ही

\<fs af='XX,n,f,pl,3,d,0,0' emph='y'\>  
\#Root will be substituted  
\>रात  
\#Step1= Seperate out emph='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>रातें\_ही

\<fs af='XX,n,f,sg,3,o,0,0' emph='y'\>  
\#Root will be substituted  
\>रात  
\#Step1= Seperate out emph='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>रात\_ही

\<fs af='XX,n,f,pl,3,o,0,0' emph='y'\>  
\#Root will be substituted  
\>रात  
\#Step1= Seperate out emph='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>रातों\_ही

\[\[Noun\_f\_e1\]\]

\<fs af='XX,n,f,sg,3,d,0,0' emph1='y'\>   
\#Root will be substituted  
\>रात  
\#Step1= Seperate out emph1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>रात\_भी

\<fs af='XX,n,f,pl,3,d,0,0' emph1='y'\>  
\#Root will be substituted  
\>रात  
\#Step1= Seperate out emph1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>रातें\_भी

\<fs af='XX,n,f,sg,3,o,0,0' emph1='y'\>  
\#Root will be substituted  
\>रात  
\#Step1= Seperate out emph1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>रात\_भी

\<fs af='XX,n,f,pl,3,o,0,0' emph1='y'\>  
\#Root will be substituted  
\>रात  
\#Step1= Seperate out emph1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value with underscore (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>रातों\_भी

\[\[Noun\_m\_rednt\]\]

\<fs af='XX,n,m,sg,3,d,0,0'\>   
\#Root will be substituted  
\>घर  
\#It can be be generated like normal noun  
\>\>घर

\<fs af='XX,n,m,pl,3,d,0,0'\>  
\#Root will be substituted  
\>घर  
\#It can be be generated like normal noun  
\>\>घर

\<fs af='XX,n,m,sg,3,o,0,0'\>  
\#Root will be substituted  
\>घर  
\#It can be be generated like normal noun  
\>\>घर

\<fs af='XX,n,m,pl,3,o,0,0'\>  
\#Root will be substituted  
\>घर  
\#It can be be generated like normal noun  
\>\>घरों

\[\[Noun\_m\_rednt\_e\]\]

\<fs af='XX,n,m,sg,3,d,0,0' rednt\_e='y'\>   
\#Root will be substituted  
\>घर  
\#Step1= Seperate out  rednt\_e='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>घर\_ही

\<fs af='XX,n,m,pl,3,d,0,0' rednt\_e='y'\>  
\#Root will be substituted  
\>घर  
\#Step1= Seperate out  rednt\_e='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>घर\_ही

\<fs af='XX,n,m,sg,3,o,0,0' rednt\_e='y'\>  
\#Root will be substituted  
\>घर  
\#Step1= Seperate out  rednt\_e='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>घर\_ही

\<fs af='XX,n,m,pl,3,o,0,0' rednt\_e='y'\>  
\#Root will be substituted  
\>घर  
\#Step1= Seperate out  rednt\_e='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>घरों\_ही

\[\[Noun\_m\_rednt\_e1\]\]

\<fs af='XX,n,m,sg,3,d,0,0' rednt\_e1='y'\>   
\#Root will be substituted  
\>घर  
\#Step1= Seperate out  rednt\_e1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>घर\_भी

\<fs af='XX,n,m,pl,3,d,0,0' rednt\_e1='y'\>  
\#Root will be substituted  
\>घर  
\#Step1= Seperate out  rednt\_e1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>घर\_भी

\<fs af='XX,n,m,sg,3,o,0,0' rednt\_e1='y'\>  
\#Root will be substituted  
\>घर  
\#Step1= Seperate out  rednt\_e1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>घर\_भी

\<fs af='XX,n,m,pl,3,o,0,0' rednt\_e1='y'\>  
\#Root will be substituted  
\>घर  
\#Step1= Seperate out  rednt\_e1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>घरों\_भी

\[\[Noun\_f\_rednt\]\]

\<fs af='XX,n,f,sg,3,d,0,0'\>   
\#Root will be substituted  
\>रात  
\#It can be be generated like normal noun  
\>\>रात

\<fs af='XX,n,f,pl,3,d,0,0'\>  
\#Root will be substituted  
\>रात  
\#It can be be generated like normal noun  
\>\>रातें

\<fs af='XX,n,f,sg,3,o,0,0'\>  
\#Root will be substituted  
\>रात  
\#It can be be generated like normal noun  
\>\>रात

\<fs af='XX,n,f,pl,3,o,0,0'\>  
\#Root will be substituted  
\>रात  
\#It can be be generated like normal noun  
\>\>रातों

\[\[Noun\_f\_rednt\_e\]\]

\<fs af='XX,n,f,sg,3,d,0,0' rednt\_e='y'\>   
\#Root will be substituted  
\>रात  
\#Step1= Seperate out  rednt\_e='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>रात\_ही

\<fs af='XX,n,f,pl,3,d,0,0' rednt\_e='y'\>  
\#Root will be substituted  
\>रात  
\#Step1= Seperate out  rednt\_e='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>रातें\_ही

\<fs af='XX,n,f,sg,3,o,0,0' rednt\_e='y'\>  
\#Root will be substituted  
\>रात  
\#Step1= Seperate out  rednt\_e='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>रात\_ही

\<fs af='XX,n,f,pl,3,o,0,0' rednt='y' emph='y'\>  
\#Root will be substituted  
\>रात  
\#Step1= Seperate out  rednt\_e='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph=hI) to the generated noun word form in terms of final noun generation  
\>\>रातों\_ही

\[\[Noun\_f\_rednt\_e1\]\]

\<fs af='XX,n,f,sg,3,d,0,0' rednt\_e1='y'\>   
\#Root will be substituted  
\>रात  
\#Step1= Seperate out  rednt\_e1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>रात\_भी

\<fs af='XX,n,f,pl,3,d,0,0' rednt\_e1='y'\>  
\#Root will be substituted  
\>रात  
\#Step1= Seperate out  rednt\_e1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>रातें\_भी

\<fs af='XX,n,f,sg,3,o,0,0' rednt\_e1='y'\>  
\#Root will be substituted  
\>रात  
\#Step1= Seperate out  rednt\_e1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>रात\_भी

\<fs af='XX,n,f,pl,3,o,0,0' rednt\_e1='y'\>  
\#Root will be substituted  
\>रात  
\#Step1= Seperate out  rednt\_e1='y'  
\#Step2= Then generate remaning morph feature directly through Hindi Morph  
\#Step3= Add emphatic value (i.e. emph1=BI) to the generated noun word form in terms of final noun generation  
\>\>रातों\_भी

\[\[Advrb\]\]

\<fs af='XX,adv,,,,,,'\>  
\#Root will be substituted  
\>कल  
No need to generate  
\>\>कल

\[\[Advrb\_e\]\]

\<fs af='XX,adv,,,,,,' emph='y'\>  
\#Root will be substituted  
\>कल  
\#Add emphatic value (i.e. emph=hI) directly to the substuted Hindi Root with underscore  
\>\>कल\_ही

\[\[Advrb\_e1\]\]

\<fs af='XX,adv,,,,,,' emph1='y'\>  
\#Root will be substituted  
\>कल  
\#Add emphatic value (i.e. emph1=BI) directly to the substuted Hindi Root with underscore  
\>\>कल\_भी

\[\[Conjunction/Interjection\]\]

\<fs af='XX,avy,,,,,,'\>  
\#Root will be substituted  
\>और  
 \#No need to generate  
\>\>और

\[\[Post-position\]\]

\<fs af='XX,psp,,,,,,'\>  
\#Root will be substituted  
\>को  
\#No need to generate  
\>\>को

\[\[Genitive-Postposition\]\]

\<fs af='XX,psp,m,sg,,d,kA,kA'\>  
\#Root and Suffix/TAM will be substituted  
\>का  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>का

\<fs af='XX,psp,m,sg,,o,kA,kA'\>  
\#Root and Suffix/TAM will be substituted  
\>का  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>के

\<fs af='XX,psp,m,pl,,d,kA,kA'\>  
\#Root and Suffix/TAM will be substituted  
\>का  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>के

\<fs af='XX,psp,m,pl,,o,kA,kA'\>  
\#Root and Suffix/TAM will be substituted  
\>का  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>के

\<fs af='XX,psp,f,sg,,d,kA,kA'\>  
\#Root and Suffix/TAM will be substituted  
\>का  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>की

\<fs af='XX,psp,f,sg,,o,kA,kA'\>  
\#Root and Suffix/TAM will be substituted  
\>का  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>की

\<fs af='XX,psp,f,pl,,d,kA,kA'\>  
\#Root and Suffix/TAM will be substituted  
\>का  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>की

\<fs af='XX,psp,f,pl,,o,kA,kA'\>  
\#Root and Suffix/TAM will be substituted  
\>का  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>की

\[\[Adj\_all\]\]

\<fs af='XX,adj,any,any,,any,,'\>  
\#Root will be substituted  
\>अमीर  
 \#No need to generate  
\>\>अमीर

\[\[Adj\_all\_e\]\]

\<fs af='XX,adj,any,any,,any,,' emph='y'\>  
\#Root will be substituted  
\>अमीर  
\#Step1= Seperate out emph='y'  
\#Step2= Add emphatic value (i.e. emph=hI) directly to the substuted Hindi Root with underscore  
\>\>अमीर\_ही

\[\[Adj\_all\_e1\]\]

\<fs af='XX,adj,any,any,,any,,' emph1='y'\>  
\#Root will be substituted  
\>अमीर  
\#Step1= Seperate out  emph1='y'  
\#Step2= Add emphatic value (i.e. emph1=BI) directly to the substuted Hindi Root with underscore  
\>\>अमीर\_भी

\[\[Adj\_case\]\]

\<fs af='XX,adj,any,pl,,d,,'\>  
\#Root will be substituted  
\>अनेक  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>अनेक

\<fs af='XX,adj,any,pl,,o,,'\>  
\#Root will be substituted  
\>अनेक  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>अनेक

\[\[Adj\_case\_e\]\]  
\<fs af='XX,adj,any,pl,,d,,' emph='y'\>  
\#Root will be substituted  
\>अनेक  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>अनेकों

\<fs af='XX,adj,any,pl,,o,,' emph='y'\>  
\#Root will be substituted  
\>अनेक  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>अनेकों

\[\[Adj\_case\_e1\]\]

\<fs af='XX,adj,any,pl,,d,,' emph1='y'\>  
\#Root will be substituted  
\>अनेक  
\#Step1= Change emph1='y' TO emph='y'  
\#Step2= Then generate modified morph feature directly through Hindi Morph  
\>\>अनेकों

\<fs af='XX,adj,any,pl,,o,,' emph1='y'\>  
\#Root will be substituted  
\>अनेक  
\#Step1= Change emph1='y' TO emph='y'  
\#Step2= Then generate modified morph feature directly through Hindi Morph  
\>\>अनेकों

\[\[Adj\_f\_s\]\]

\<fs af='XX,adj,f,sg,,any,,'\>  
\#Root will be substituted  
\>बालिका  
\#No need to generate  
\>\>बालिका

\[\[Adj\_m\_s\]\]

\<fs af='XX,adj,m,sg,,any,,'\>  
\#Root will be substituted  
\>बालक  
 No need to generate  
\>\>बालक

\[\[Adj\_m\_vAlA\]\]

\<fs af='XX,adj,m,any,,any,,'\>  
\#Root will be substituted  
\>काला  
\#Step 1= Change the feature from \<fs af='XX,adj,m,any,,any,,'\> TO \<fs af='XX,adj,m,sg,,d,,'\>  
\#Step 2= Generate modified morph feature directly through inverted Hindi Morph  
\>\>काला

\[\[Agr\_based\_feature\]\]

\<fs af='XX,adj,m,sg,,d,,'\>  
\>काला  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>काला

\[\[Agr\_based\_feature\]\]

\<fs af='XX,adj,m,sg,,o,,'\>  
\>काला  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>काले

\[\[Agr\_based\_feature\]\]

\<fs af='XX,adj,m,pl,,d,,'\>  
\>काला  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>काले

\[\[Agr\_based\_feature\]\]

\<fs af='XX,adj,m,pl,,o,,'\>  
\>काला  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>काले

\[\[Adj\_m\_e\_vAlA\]\]

\<fs af='XX,adj,m,any,,any,,' emph='y'\>  
\#Root will be substituted  
\>काला  
\#Step 1= Change the feature from \<fs af='XX,adj,m,any,,any,,' emph='y'\> TO \<fs af='XX,adj,m,sg,,d,,' emph='y'\>  
\#Step 2= Remove emph='y' from feature  
\#Step 3= Generate remaining morph feature directly through inverted Hindi Morph  
\>\>काला

\[\[Agr\_based\_feature\]\]

\<fs af='XX,adj,m,sg,,d,,' emph='y'\>  
\>काला  
\#Step 1= Remove emph='y' from feature  
\#Step 2= Generate remaining morph feature directly through inverted Hindi Morph  
\>\>काले

\[\[Agr\_based\_feature\]\]

\<fs af='XX,adj,m,sg,,o,,' emph='y'\>  
\>काला  
\#Step 1= Remove emph='y' from feature  
\#Step 2= Generate remaining morph feature directly through inverted Hindi Morph  
\>\>काले

\[\[Agr\_based\_feature\]\]

\<fs af='XX,adj,m,pl,,d,,' emph='y'\>  
\>काला  
\#Step 1= Remove emph='y' from feature  
\#Step 2= Generate remaining morph feature directly through inverted Hindi Morph  
\>\>काले

\[\[Agr\_based\_feature\]\]

\<fs af='XX,adj,m,pl,,o,,' emph='y'\>  
\>काला  
\#Step 1= Remove emph='y' from feature  
\#Step 2= Generate remaining morph feature directly through inverted Hindi Morph  
\>\>काले

\[\[Adj\_m\_e1\_vAlA\]\]

\<fs af='XX,adj,m,any,,any,,' emph1='y'\>  
\#Root will be substituted  
\>काला  
\#Step 1= Change the feature from \<fs af='XX,adj,m,any,,any,,' emph1='y'\> TO \<fs af='XX,adj,m,sg,,d,,' emph1='y'\>  
\#Step 2= Remove emph1='y' from feature  
\#Step 3= Generate remaining morph feature directly through inverted Hindi Morph  
\>\>काला

\[\[Agr\_based\_feature\]\]

\<fs af='XX,adj,m,sg,,d,,' emph1='y'\>  
\>काला  
\#Step 1= Remove emph1='y' from feature  
\#Step 2= Generate remaining morph feature directly through inverted Hindi Morph  
\>\>काला

\[\[Agr\_based\_feature\]\]

\<fs af='XX,adj,m,sg,,o,,' emph1='y'\>  
\>काला  
\#Step 1= Remove emph1='y' from feature  
\#Step 2= Generate remaining morph feature directly through inverted Hindi Morph  
\>\>काले

\[\[Agr\_based\_feature\]\]

\<fs af='XX,adj,m,pl,,d,,' emph1='y'\>  
\>काला  
\#Step 1= Remove emph1='y' from feature  
\#Step 2= Generate remaining morph feature directly through inverted Hindi Morph  
\>\>काले

\[\[Agr\_based\_feature\]\]

\<fs af='XX,adj,m,pl,,o,,' emph1='y'\>  
\>काला  
\#Step 1= Remove emph1='y' from feature  
\#Step 2= Generate remaining morph feature directly through inverted Hindi Morph  
\>\>काले

\[\[Adj\_f\_vAlI\]\]

\<fs af='XX,adj,f,any,,any,,'\>  
\#Root will be substituted  
\>काली  
\#No need to generate  
\>\>काली

\[\[Adj\_f\_e\_vAlI\]\]

\<fs af='XX,adj,f,any,,any,,' emph='y'\>  
\#Root will be substituted  
\>काली  
\#No need to generate  
\>\>काली

\[\[Adj\_f\_e1\_vAlI\]\]

\<fs af='XX,adj,f,any,,any,,' emph1='y'\>  
\#Root will be substituted  
\>काली  
\#No need to generate  
\>\>काली

\[\[Pro\_u\]\]

\<fs af='हम,pn,any,sg,1,o,0,0'\>

\<fs af='मैं,pn,any,sg,1,o,0,0'\>  
\>\>मुझ

\<fs af='हम,pn,any,sg,1,o,ko,ko'\>

\<fs af='मैं,pn,any,sg,1,o,ko,ko'\>  
\>\>मुझे|मुझको

\<fs af='हम,pn,any,sg,1,o,se,se'\>

\<fs af='मैं,pn,any,sg,1,o,se,se'\>  
\>\>मुझसे

\<fs af='हम,pn,any,sg,1,o,meM,meM'\>

\<fs af='मैं,pn,any,sg,1,o,meM,meM'\>  
\>\>मुझमें

\<fs af='हम,pn,any,sg,1,o,para,para'\>

\<fs af='मैं,pn,any,sg,1,o,para,para'\>  
\>\>मुझपर

\<fs af='हम,pn,any,pl,1,o,0,0'\> 

\<fs af='मैं,pn,any,pl,1,o,0,0'\>   
\>\>हम

\<fs af='हम,pn,any,pl,1,o,ko,ko'\>

\<fs af='मैं,pn,any,pl,1,o,ko,ko'\>  
\>\>हमें|हमको

\<fs af='हम,pn,any,pl,1,o,se,se'\>

\<fs af='मैं,pn,any,pl,1,o,se,se'\>  
\>\>हमसे

\<fs af='हम,pn,any,pl,1,o,meM,meM'\>

\<fs af='मैं,pn,any,pl,1,o,meM,meM'\>  
\>\>हममें

\<fs af='हम,pn,any,pl,1,o,para,para'\>

\<fs af='मैं,pn,any,pl,1,o,para,para'\>

\>\>हमपर

\[\[Pro\_u\_e\]\]

\<fs af='हम,pn,any,sg,1,o,0,0' emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,0,0' emph='y'\>  
\>\>मुझी|मुझ\_ही

\<fs af='हम,pn,any,sg,1,o,ko,ko' emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,ko,ko' emph='y'\>  
\>\>मुझीको|मुझ\_ही\_को

\<fs af='हम,pn,any,sg,1,o,se,se' emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,se,se' emph='y'\>  
\>\>मुझीसे|मुझ\_ही\_से

\<fs af='हम,pn,any,sg,1,o,meM,meM' emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,meM,meM' emph='y'\>  
\>\>मुझीमें|मुझ\_ही\_में

\<fs af='हम,pn,any,sg,1,o,para,para' emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,para,para' emph='y'\>  
\>\>मुझीपर|मुझ\_ही\_पर

\<fs af='हम,pn,any,pl,1,o,0,0' emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,0,0' emph='y'\>  
\>\>हमीं|हम\_ही

\<fs af='हम,pn,any,pl,1,o,ko,ko' emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,ko,ko' emph='y'\>  
\>\>हमींको|हम\_ही\_को

\<fs af='हम,pn,any,pl,1,o,se,se' emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,se,se' emph='y'\>  
\>\>हमींसे|हम\_ही\_से

\<fs af='हम,pn,any,pl,1,o,meM,meM' emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,meM,meM' emph='y'\>  
\>\>हमींमें|हम\_ही\_में

\<fs af='हम,pn,any,pl,1,o,para,para' emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,para,para' emph='y'\>  
\>\>हमींपर|हम\_ही\_पर

\[\[Pro\_u\_e1\]\]

\<fs af='हम,pn,any,sg,1,o,0,0' emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,0,0' emph1='y'\>  
\>\>मुझ

\<fs af='हम,pn,any,sg,1,o,ko,ko' emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,ko,ko' emph1='y'\>  
\>\>मुझको\_भी

\<fs af='हम,pn,any,sg,1,o,se,se' emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,se,se' emph1='y'\>  
\>\>मुझसे\_भी

\<fs af='हम,pn,any,sg,1,o,meM,meM' emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,meM,meM' emph1='y'\>  
\>\>मुझ\_में\_भी

\<fs af='हम,pn,any,sg,1,o,para,para' emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,para,para' emph1='y'\>  
\>\>मुझ\_पर\_भी

\<fs af='हम,pn,any,pl,1,o,0,0' emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,0,0' emph1='y'\>  
\>\>हम

\<fs af='हम,pn,any,pl,1,o,ko,ko' emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,ko,ko' emph1='y'\>  
\>\>हमको\_भी

\<fs af='हम,pn,any,pl,1,o,se,se' emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,se,se' emph1='y'\>  
\>\>हमसे\_भी

\<fs af='हम,pn,any,pl,1,o,meM,meM' emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,meM,meM' emph1='y'\>  
\>\>हम\_में\_भी

\<fs af='हम,pn,any,pl,1,o,para,para' emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,para,para' emph1='y'\>  
\>\>हम\_पर\_भी

\[\[Pro\_d\_u\]\]

\<fs af='हम,pn,any,sg,1,d,0,0'\>

\<fs af='मैं,pn,any,sg,1,d,0,0'\>  
\>\>मैं

\<fs af='हम,pn,any,pl,1,d,0,0'\>

\<fs af='मैं,pn,any,pl,1,d,0,0'\>  
\>\>हम

\[\[Pro\_d\_u\_e\]\]

\<fs af='हम,pn,any,sg,1,d,0,0' emph='y'\>

\<fs af='मैं,pn,any,sg,1,d,0,0' emph='y'\>  
\>\>मैं\_ही

\<fs af='हम,pn,any,pl,1,d,0,0' emph='y'\>

\<fs af='मैं,pn,any,pl,1,d,0,0' emph='y'\>  
\>\>हमीं|हम\_ही

\[\[Pro\_d\_u\_e1\]\]

\<fs af='हम,pn,any,sg,1,d,0,0' emph1='y'\>

\<fs af='मैं,pn,any,sg,1,d,0,0' emph1='y'\>  
\>\>मैं\_भी

\<fs af='हम,pn,any,pl,1,d,0,0' emph1='y'\>

\<fs af='मैं,pn,any,pl,1,d,0,0' emph1='y'\>  
\>\>हमीं|हम\_भी

\[\[Pro\_o\_u\]\]

\<fs af='आपन,pn,any,pl,1,o,0,0'\>

\<fs af='अपना,pn,any,pl,1,o,0,0'\>  
\>\>अपनों

\[\[Pro\_m\]\]

\<fs af='तू,pn,any,sg,2,o,0,0'\>

\<fs af='तू,pn,any,sg,2,o,0,0'\>  
\>\>तुझ

\<fs af='तू,pn,any,sg,2,o,ko,ko'\>

\<fs af='तू,pn,any,sg,2,o,ko,ko'\>  
\>\>तुझे|तुझको

\<fs af='तू,pn,any,sg,2,o,se,se'\>

\<fs af='तू,pn,any,sg,2,o,se,se'\>  
\>\>तुझसे

\<fs af='तू,pn,any,sg,2,o,meM,meM'\>

\<fs af='तू,pn,any,sg,2,o,meM,meM'\>  
\>\>तुझमें

\<fs af='तू,pn,any,sg,2,o,para,para'\>

\<fs af='तू,pn,any,sg,2,o,para,para'\>  
\>\>तुझपर

\<fs af='तू,pn,any,pl,2,o,0,0'\>

\<fs af='तू,pn,any,pl,2,o,0,0'\>  
\>\>तुम

\<fs af='तू,pn,any,pl,2,o,ko,ko'\>

\<fs af='तू,pn,any,pl,2,o,ko,ko'\>  
\>\>तुम्हें|तुमको

\<fs af='तू,pn,any,pl,2,o,se,se'\>

\<fs af='तू,pn,any,pl,2,o,se,se'\>  
\>\>तुमसे

\<fs af='तू,pn,any,pl,2,o,meM,meM'\>

\<fs af='तू,pn,any,pl,2,o,meM,meM'\>  
\>\>तुममें

\<fs af='तू,pn,any,pl,2,o,para,para'\>

\<fs af='तू,pn,any,pl,2,o,para,para'\>  
\>\>तुमपर

\[\[Pro\_m\_e\]\]

\<fs af='तू,pn,any,sg,2,o,0,0' emph='y'\>

\<fs af='तू,pn,any,sg,2,o,0,0' emph='y'\>  
\>\>तुझी|तुझ\_ही

\<fs af='तू,pn,any,sg,2,o,ko,ko' emph='y'\>

\<fs af='तू,pn,any,sg,2,o,ko,ko' emph='y'\>  
\>\>तुझीको|तुझ\_ही\_को

\<fs af='तू,pn,any,sg,2,o,se,se' emph='y'\>

\<fs af='तू,pn,any,sg,2,o,se,se' emph='y'\>  
\>\>तुझीसे|तुझ\_ही\_से

\<fs af='तू,pn,any,sg,2,o,meM,meM' emph='y'\>

\<fs af='तू,pn,any,sg,2,o,meM,meM' emph='y'\>  
\>\>तुझीमें|तुझ\_ही\_में

\<fs af='तू,pn,any,sg,2,o,para,para' emph='y'\>

\<fs af='तू,pn,any,sg,2,o,para,para' emph='y'\>  
\>\>तुझीपर|तुझ\_ही\_पर

\<fs af='तू,pn,any,pl,2,o,0,0' emph='y'\>

\<fs af='तू,pn,any,pl,2,o,0,0' emph='y'\>  
\>\>तुम्हीं|तुम\_ही

\<fs af='तू,pn,any,pl,2,o,ko,ko' emph='y'\>

\<fs af='तू,pn,any,pl,2,o,ko,ko' emph='y'\>  
\>\>तुम्हींको|तुम\_ही\_को

\<fs af='तू,pn,any,pl,2,o,se,se' emph='y'\>

\<fs af='तू,pn,any,pl,2,o,se,se' emph='y'\>  
\>\>तुम्हींसे|तुम\_ही\_से

\<fs af='तू,pn,any,pl,2,o,meM,meM' emph='y'\>

\<fs af='तू,pn,any,pl,2,o,meM,meM' emph='y'\>  
\>\>तुम्हींमें|तुम\_ही\_में

\<fs af='तू,pn,any,pl,2,o,para,para' emph='y'\>

\<fs af='तू,pn,any,pl,2,o,para,para' emph='y'\>  
\>\>तुम्हींपर|तुम\_ही\_पर

\[\[Pro\_m\_e1\]\]

\<fs af='तू,pn,any,sg,2,o,0,0' emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,0,0' emph1='y'\>  
\>\>तुझ

\<fs af='तू,pn,any,sg,2,o,ko,ko' emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,ko,ko' emph1='y'\>  
\>\>तुझको\_भी

\<fs af='तू,pn,any,sg,2,o,se,se' emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,se,se' emph1='y'\>  
\>\>तुझसे\_भी

\<fs af='तू,pn,any,sg,2,o,meM,meM' emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,meM,meM' emph1='y'\>  
\>\>तुझ\_में\_भी

\<fs af='तू,pn,any,sg,2,o,para,para' emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,para,para' emph1='y'\>  
\>\>तुझ\_पर\_भी

\<fs af='तू,pn,any,pl,2,o,0,0' emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,0,0' emph1='y'\>  
\>\>तुम

\<fs af='तू,pn,any,pl,2,o,ko,ko' emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,ko,ko' emph1='y'\>  
\>\>तुमको\_भी

\<fs af='तू,pn,any,pl,2,o,se,se' emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,se,se' emph1='y'\>  
\>\>तुम\_से\_भी

\<fs af='तू,pn,any,pl,2,o,meM,meM' emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,meM,meM' emph1='y'\>  
\>\>तुम\_में\_भी

\<fs af='तू,pn,any,pl,2,o,para,para' emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,para,para' emph1='y'\>  
\>\>तुम\_पर\_भी

\[\[Pro\_d\_m\]\]

\<fs af='तू,pn,any,sg,2,d,0,0'\>

\<fs af='तू,pn,any,sg,2,d,0,0'\>  
\>\>तू

\<fs af='तू,pn,any,pl,2,d,0,0'\>

\<fs af='तू,pn,any,pl,2,d,0,0'\>  
\>\>तुम

\[\[Pro\_d\_m\_e\]\]

\<fs af='तू,pn,any,sg,2,d,0,0' emph='y'\>

\<fs af='तू,pn,any,sg,2,d,0,0' emph='y'\>  
\>\>तू\_ही

\<fs af='तू,pn,any,pl,2,d,0,0' emph='y'\>

\<fs af='तू,pn,any,pl,2,d,0,0' emph='y'\>  
\>\>तुम्ही|तुम\_ही

\[\[Pro\_d\_m\_e1\]\]

\<fs af='तू,pn,any,sg,2,d,0,0' emph1='y'\>

\<fs af='तू,pn,any,sg,2,d,0,0' emph1='y'\>  
\>\>तू\_भी

\<fs af='तू,pn,any,pl,2,d,0,0' emph1='y'\>

\<fs af='तू,pn,any,pl,2,d,0,0' emph1='y'\>  
\>\>तुम\_भी

\[\[Pro\_a\]\]

\<fs af='उ,pn,any,sg,3,o,0,0'\>

\<fs af='वह,pn,any,sg,3,o,0,0'\>  
\>\>उस

\<fs af='उ,pn,any,sg,3,o,ko,ko'\>

\<fs af='वह,pn,any,sg,3,o,ko,ko'\>  
\>\>उसको|उसे

\<fs af='उ,pn,any,sg,3,o,se,se'\>

\<fs af='वह,pn,any,sg,3,o,se,se'\>  
\>\>उससे

\<fs af='उ,pn,any,sg,3,o,meM,meM'\>

\<fs af='वह,pn,any,sg,3,o,meM,meM'\>  
\>\>उसमें

\<fs af='उ,pn,any,sg,3,o,para,para'\>

\<fs af='वह,pn,any,sg,3,o,para,para'\>  
\>\>उसपर

\<fs af='उ,pn,any,pl,3,o,0,0'\>

\<fs af='वह,pn,any,pl,3,o,0,0'\>  
\>\>उन

\<fs af='उ,pn,any,pl,3,o,ko,ko'\>

\<fs af='वह,pn,any,pl,3,o,ko,ko'\>  
\>\>उन्हें|उनको

\<fs af='उ,pn,any,pl,3,o,se,se'\>

\<fs af='वह,pn,any,pl,3,o,se,se'\>  
\>\>उनसे

\<fs af='उ,pn,any,pl,3,o,meM,meM'\>

\<fs af='वह,pn,any,pl,3,o,meM,meM'\>  
\>\>उनमें

\<fs af='उ,pn,any,pl,3,o,para,para'\>

\<fs af='वह,pn,any,pl,3,o,para,para'\>  
\>\>उनपर

\<fs af='इ,pn,any,sg,3,o,0,0'\>

\<fs af='यह,pn,any,sg,3,o,0,0'\>  
\>\>इस

\<fs af='इ,pn,any,sg,3,o,ko,ko'\>

\<fs af='यह,pn,any,sg,3,o,ko,ko'\>  
\>\>इसे|इसको

\<fs af='इ,pn,any,sg,3,o,se,se'\>

\<fs af='यह,pn,any,sg,3,o,se,se'\>  
\>\>इससे

\<fs af='इ,pn,any,sg,3,o,meM,meM'\>

\<fs af='यह,pn,any,sg,3,o,meM,meM'\>  
\>\>इसमें

\<fs af='इ,pn,any,sg,3,o,para,para'\>

\<fs af='यह,pn,any,sg,3,o,para,para'\>  
\>\>इसपर

\<fs af='इ,pn,any,pl,3,o,0,0'\>

\<fs af='यह,pn,any,pl,3,o,0,0'\>  
\>\>इन

\<fs af='इ,pn,any,pl,3,o,ko,ko'\>

\<fs af='यह,pn,any,pl,3,o,ko,ko'\>  
\>\>इन्हें|इनको

\<fs af='इ,pn,any,pl,3,o,se,se'\>

\<fs af='यह,pn,any,pl,3,o,se,se'\>  
\>\>इनसे

\<fs af='इ,pn,any,pl,3,o,meM,meM'\>

\<fs af='यह,pn,any,pl,3,o,meM,meM'\>  
\>\>इनमें

\<fs af='इ,pn,any,pl,3,o,para,para'\>

\<fs af='यह,pn,any,pl,3,o,para,para'\>  
\>\>इनपर

\<fs af='जे,pn,any,sg,3,o,0,0'\>

\<fs af='जो,pn,any,sg,3,o,0,0'\>  
\>\>जिस

\<fs af='जे,pn,any,sg,3,o,ko,ko'\>

\<fs af='जो,pn,any,sg,3,o,ko,ko'\>  
\>\>जिसे|जिसको

\<fs af='जे,pn,any,sg,3,o,se,se'\>

\<fs af='जो,pn,any,sg,3,o,se,se'\>  
\>\>जिससे

\<fs af='जे,pn,any,sg,3,o,meM,meM'\>

\<fs af='जो,pn,any,sg,3,o,meM,meM'\>  
\>\>जिसमें

\<fs af='जे,pn,any,sg,3,o,para,para'\>

\<fs af='जो,pn,any,sg,3,o,para,para'\>  
\>\>जिसपर

\<fs af='जे,pn,any,pl,3,o,0,0'\>

\<fs af='जो,pn,any,pl,3,o,0,0'\>  
\>\>जिन

\<fs af='जे,pn,any,pl,3,o,ko,ko'\>

\<fs af='जो,pn,any,pl,3,o,ko,ko'\>  
\>\>जिन्हें|जिनको

\<fs af='जे,pn,any,pl,3,o,se,se'\>

\<fs af='जो,pn,any,pl,3,o,se,se'\>  
\>\>जिनसे

\<fs af='जे,pn,any,pl,3,o,meM,meM'\>

\<fs af='जो,pn,any,pl,3,o,meM,meM'\>  
\>\>जिनमें

\<fs af='जे,pn,any,pl,3,o,para,para'\>

\<fs af='जो,pn,any,pl,3,o,para,para'\>  
\>\>जिनपर

\<fs af='कवन,pn,any,sg,3,o,0,0'\>

\<fs af='कौन,pn,any,sg,3,o,0,0'\>  
\>\>किस

\<fs af='कवन,pn,any,sg,3,o,ko,ko'\>

\<fs af='कौन,pn,any,sg,3,o,ko,ko'\>  
\>\>किसे|किसको

\<fs af='कवन,pn,any,sg,3,o,se,se'\>

\<fs af='कौन,pn,any,sg,3,o,se,se'\>  
\>\>किससे

\<fs af='कवन,pn,any,sg,3,o,meM,meM'\>

\<fs af='कौन,pn,any,sg,3,o,meM,meM'\>  
\>\>किसमें

\<fs af='कवन,pn,any,sg,3,o,para,para'\>

\<fs af='कौन,pn,any,sg,3,o,para,para'\>  
\>\>किसपर

\<fs af='कवन,pn,any,pl,3,o,0,0'\>

\<fs af='कौन,pn,any,pl,3,o,0,0'\>  
\>\>किन

\<fs af='कवन,pn,any,pl,3,o,ko,ko'\>

\<fs af='कौन,pn,any,pl,3,o,ko,ko'\>  
\>\>किन्हें|किनको

\<fs af='कवन,pn,any,pl,3,o,se,se'\>

\<fs af='कौन,pn,any,pl,3,o,se,se'\>  
\>\>किनसे

\<fs af='कवन,pn,any,pl,3,o,meM,meM'\>

\<fs af='कौन,pn,any,pl,3,o,meM,meM'\>  
\>\>किनमें

\<fs af='कवन,pn,any,pl,3,o,para,para'\>

\<fs af='कौन,pn,any,pl,3,o,para,para'\>  
\>\>किनपर

\<fs af='केहु,pn,any,sg,3,o,0,0'\>

\<fs af='कोई,pn,any,sg,3,o,0,0'\>  
\>\>किसी

\<fs af='केहु,pn,any,sg,3,o,ko,ko'\>

\<fs af='कोई,pn,any,sg,3,o,ko,ko'\>  
\>\>किसी\_को

\<fs af='केहु,pn,any,sg,3,o,se,se'\>

\<fs af='कोई,pn,any,sg,3,o,se,se'\>  
\>\>किसी\_से

\<fs af='केहु,pn,any,sg,3,o,meM,meM'\>

\<fs af='कोई,pn,any,sg,3,o,meM,meM'\>  
\>\>किसी\_में

\<fs af='केहु,pn,any,sg,3,o,para,para'\>

\<fs af='कोई,pn,any,sg,3,o,para,para'\>  
\>\>किसी\_पर

\<fs af='केहु,pn,any,pl,3,o,0,0'\>

\<fs af='कोई,pn,any,pl,3,o,0,0'\>  
\>\>किन्हीं

\<fs af='केहु,pn,any,pl,3,o,ko,ko'\>

\<fs af='कोई,pn,any,pl,3,o,ko,ko'\>  
\>\>किन्हीं\_को

\<fs af='केहु,pn,any,pl,3,o,se,se'\>

\<fs af='कोई,pn,any,pl,3,o,se,se'\>  
\>\>किन्ही\_से

\<fs af='केहु,pn,any,pl,3,o,meM,meM'\>

\<fs af='कोई,pn,any,pl,3,o,meM,meM'\>  
\>\>किन्हीं\_में

\<fs af='केहु,pn,any,pl,3,o,para,para'\>

\<fs af='कोई,pn,any,pl,3,o,para,para'\>  
\>\>किन्हीं\_पर

\<fs af='सब,pn,any,pl,3,o,ko,ko'\>

\<fs af='सब,pn,any,pl,3,o,ko,ko'\>  
\>\>सबको

\<fs af='सब,pn,any,pl,3,o,se,se'\>

\<fs af='सब,pn,any,pl,3,o,se,se'\>  
\>\>सबसे

\<fs af='सब,pn,any,pl,3,o,meM,meM'\>

\<fs af='सब,pn,any,pl,3,o,meM,meM'\>  
\>\>सबमें

\<fs af='सब,pn,any,pl,3,o,para,para'\>

\<fs af='सब,pn,any,pl,3,o,para,para'\>  
\>\>सबपर

\[\[Pro\_a\_e\]\]

\<fs af='उ,pn,any,sg,3,o,0,0' emph='y'\>

\<fs af='वह,pn,any,sg,3,o,0,0' emph='y'\>  
\>\>उसी

\<fs af='उ,pn,any,sg,3,o,ko,ko' emph='y'\>

\<fs af='वह,pn,any,sg,3,o,ko,ko' emph='y'\>  
\>\>उसीको|उसे\_ही

\<fs af='उ,pn,any,sg,3,o,se,se' emph='y'\>

\<fs af='वह,pn,any,sg,3,o,se,se' emph='y'\>  
\>\>उसीसे

\<fs af='उ,pn,any,sg,3,o,meM,meM' emph='y'\>

\<fs af='वह,pn,any,sg,3,o,meM,meM' emph='y'\>  
\>\>उसीमें

\<fs af='उ,pn,any,sg,3,o,para,para' emph='y'\>

\<fs af='वह,pn,any,sg,3,o,para,para' emph='y'\>  
\>\>उसीपर

\<fs af='उ,pn,any,pl,3,o,0,0' emph='y'\>

\<fs af='वह,pn,any,pl,3,o,0,0' emph='y'\>  
\>\>उन्हीं

\<fs af='उ,pn,any,pl,3,o,ko,ko' emph='y'\>

\<fs af='वह,pn,any,pl,3,o,ko,ko' emph='y'\>  
\>\>उन्हें\_ही|उन्हीं\_को

\<fs af='उ,pn,any,pl,3,o,se,se' emph='y'\>

\<fs af='वह,pn,any,pl,3,o,se,se' emph='y'\>  
\>\>उन्हीं\_से

\<fs af='उ,pn,any,pl,3,o,meM,meM' emph='y'\>

\<fs af='वह,pn,any,pl,3,o,meM,meM' emph='y'\>  
\>\>उन्हीं\_में

\<fs af='उ,pn,any,pl,3,o,para,para' emph='y'\>

\<fs af='वह,pn,any,pl,3,o,para,para' emph='y'\>  
\>\>उन्हीं\_पर

\<fs af='इ,pn,any,sg,3,o,0,0' emph='y'\>

\<fs af='यह,pn,any,sg,3,o,0,0' emph='y'\>  
\>\>इसी

\<fs af='इ,pn,any,sg,3,o,ko,ko' emph='y'\>

\<fs af='यह,pn,any,sg,3,o,ko,ko' emph='y'\>  
\>\>इसे\_ही|इसी\_को

\<fs af='इ,pn,any,sg,3,o,se,se' emph='y'\>

\<fs af='यह,pn,any,sg,3,o,se,se' emph='y'\>  
\>\>इसी\_से

\<fs af='इ,pn,any,sg,3,o,meM,meM' emph='y'\>

\<fs af='यह,pn,any,sg,3,o,meM,meM' emph='y'\>  
\>\>इसी\_में

\<fs af='इ,pn,any,sg,3,o,para,para' emph='y'\>

\<fs af='यह,pn,any,sg,3,o,para,para' emph='y'\>  
\>\>इसी\_पर

\<fs af='इ,pn,any,pl,3,o,0,0' emph='y'\>

\<fs af='यह,pn,any,pl,3,o,0,0' emph='y'\>  
\>\>इन्हीं

\<fs af='इ,pn,any,pl,3,o,ko,ko' emph='y'\>

\<fs af='यह,pn,any,pl,3,o,ko,ko' emph='y'\>  
\>\>इन्हें\_ही|इन्हीं\_को

\<fs af='इ,pn,any,pl,3,o,se,se' emph='y'\>

\<fs af='यह,pn,any,pl,3,o,se,se' emph='y'\>  
\>\>इन्हीं\_से

\<fs af='इ,pn,any,pl,3,o,meM,meM' emph='y'\>

\<fs af='यह,pn,any,pl,3,o,meM,meM' emph='y'\>  
\>\>इन्हीं\_में

\<fs af='इ,pn,any,pl,3,o,para,para' emph='y'\>

\<fs af='यह,pn,any,pl,3,o,para,para' emph='y'\>  
\>\>इन्हीं\_पर

\<fs af='जे,pn,any,sg,3,o,0,0' emph='y'\>

\<fs af='जो,pn,any,sg,3,o,0,0' emph='y'\>  
\>\>जिसी|जिस\_ही

\<fs af='जे,pn,any,sg,3,o,ko,ko' emph='y'\>

\<fs af='जो,pn,any,sg,3,o,ko,ko' emph='y'\>  
\>\>जिसे\_ही|जिसको\_ही

\<fs af='जे,pn,any,sg,3,o,se,se' emph='y'\>

\<fs af='जो,pn,any,sg,3,o,se,se' emph='y'\>  
\>\>जिससे\_ही|जिसी\_से\_ही

\<fs af='जे,pn,any,sg,3,o,meM,meM' emph='y'\>

\<fs af='जो,pn,any,sg,3,o,meM,meM' emph='y'\>  
\>\>जिसमें\_ही

\<fs af='जे,pn,any,sg,3,o,para,para' emph='y'\>

\<fs af='जो,pn,any,sg,3,o,para,para' emph='y'\>  
\>\>जिसपर\_ही

\<fs af='जे,pn,any,pl,3,o,0,0' emph='y'\>

\<fs af='जो,pn,any,pl,3,o,0,0' emph='y'\>  
\>\>जिन्हीं

\<fs af='जे,pn,any,pl,3,o,ko,ko' emph='y'\>

\<fs af='जो,pn,any,pl,3,o,ko,ko' emph='y'\>  
\>\>जिन्हें\_ही|जिनको\_ही

\<fs af='जे,pn,any,pl,3,o,se,se' emph='y'\>

\<fs af='जो,pn,any,pl,3,o,se,se' emph='y'\>  
\>\>जिनसे\_ही

\<fs af='जे,pn,any,pl,3,o,meM,meM' emph='y'\>

\<fs af='जो,pn,any,pl,3,o,meM,meM' emph='y'\>  
\>\>जिनमें\_ही

\<fs af='जे,pn,any,pl,3,o,para,para' emph='y'\>

\<fs af='जो,pn,any,pl,3,o,para,para' emph='y'\>  
\>\>जिनपर\_ही

\<fs af='कवन,pn,any,sg,3,o,0,0' emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,0,0' emph='y'\>  
\>\>किसी

\<fs af='कवन,pn,any,sg,3,o,ko,ko' emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,ko,ko' emph='y'\>  
\>\>किस\_ही|किसको\_ही

\<fs af='कवन,pn,any,sg,3,o,se,se' emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,se,se' emph='y'\>  
\>\>किससे\_ही

\<fs af='कवन,pn,any,sg,3,o,meM,meM' emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,meM,meM' emph='y'\>  
\>\>किसमें\_ही

\<fs af='कवन,pn,any,sg,3,o,para,para' emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,para,para' emph='y'\>  
\>\>किसपर\_ही

\<fs af='कवन,pn,any,pl,3,o,0,0' emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,0,0' emph='y'\>  
\>\>किन्हीं

\<fs af='कवन,pn,any,pl,3,o,ko,ko' emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,ko,ko' emph='y'\>  
\>\>किन्हें\_ही|किनको\_ही|किन्हीं\_को

\<fs af='कवन,pn,any,pl,3,o,se,se' emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,se,se' emph='y'\>  
\>\>किनसे\_ही|किन्हीं\_से

\<fs af='कवन,pn,any,pl,3,o,meM,meM' emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,meM,meM' emph='y'\>  
\>\>किनमें\_ही|किन्हीं\_में

\<fs af='कवन,pn,any,pl,3,o,para,para' emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,para,para' emph='y'\>  
\>\>किनपर\_ही|किन्हीं\_पर

\<fs af='केहु,pn,any,sg,3,o,0,0' emph='y'\>

\<fs af='कोई,pn,any,sg,3,o,0,0' emph='y'\>  
\>\>किसी

\<fs af='केहु,pn,any,sg,3,o,ko,ko' emph='y'\>

\<fs af='कोई,pn,any,sg,3,o,ko,ko' emph='y'\>  
\>\>किसी\_को\_ही

\<fs af='केहु,pn,any,sg,3,o,se,se' emph='y'\>

\<fs af='कोई,pn,any,sg,3,o,se,se' emph='y'\>  
\>\>किसी\_से\_ही

\<fs af='केहु,pn,any,sg,3,o,meM,meM' emph='y'\>

\<fs af='कोई,pn,any,sg,3,o,meM,meM' emph='y'\>  
\>\>किसी\_में\_ही

\<fs af='केहु,pn,any,sg,3,o,para,para' emph='y'\>

\<fs af='कोई,pn,any,sg,3,o,para,para' emph='y'\>  
\>\>किसी\_पर\_ही

\<fs af='केहु,pn,any,pl,3,o,0,0' emph='y'\>

\<fs af='कोई,pn,any,pl,3,o,0,0' emph='y'\>  
\>\>किन्हीं

\<fs af='केहु,pn,any,pl,3,o,ko,ko' emph='y'\>

\<fs af='कोई,pn,any,pl,3,o,ko,ko' emph='y'\>  
\>\>किन्हीं\_को\_ही

\<fs af='केहु,pn,any,pl,3,o,se,se' emph='y'\>

\<fs af='कोई,pn,any,pl,3,o,se,se' emph='y'\>  
\>\>किन्ही\_से\_ही

\<fs af='केहु,pn,any,pl,3,o,meM,meM' emph='y'\>

\<fs af='कोई,pn,any,pl,3,o,meM,meM' emph='y'\>  
\>\>किन्हीं\_में\_ही

\<fs af='केहु,pn,any,pl,3,o,para,para' emph='y'\>

\<fs af='कोई,pn,any,pl,3,o,para,para' emph='y'\>  
\>\>किन्हीं\_पर\_ही

\<fs af='सब,pn,any,pl,3,o,ko,ko' emph='y'\>

\<fs af='सब,pn,any,pl,3,o,ko,ko' emph='y'\>  
\>\>सबको\_ही

\<fs af='सब,pn,any,pl,3,o,se,se' emph='y'\>

\<fs af='सब,pn,any,pl,3,o,se,se' emph='y'\>  
\>\>सबसे\_ही

\<fs af='सब,pn,any,pl,3,o,meM,meM' emph='y'\>

\<fs af='सब,pn,any,pl,3,o,meM,meM' emph='y'\>  
\>\>सबमें\_ही

\<fs af='सब,pn,any,pl,3,o,para,para' emph='y'\>

\<fs af='सब,pn,any,pl,3,o,para,para' emph='y'\>  
\>\>सबपर\_ही

\[\[Pro\_a\_e1\]\]

\<fs af='उ,pn,any,sg,3,o,0,0' emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,0,0' emph1='y'\>  
\>\>उस

\<fs af='उ,pn,any,sg,3,o,ko,ko' emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,ko,ko' emph1='y'\>  
\>\>उसको\_भी|उसे\_भी

\<fs af='उ,pn,any,sg,3,o,se,se' emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,se,se' emph1='y'\>  
\>\>उससे\_भी

\<fs af='उ,pn,any,sg,3,o,meM,meM' emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,meM,meM' emph1='y'\>  
\>\>उसमें\_भी

\<fs af='उ,pn,any,sg,3,o,para,para' emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,para,para' emph1='y'\>  
\>\>उसपर\_भी

\<fs af='उ,pn,any,pl,3,o,0,0' emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,0,0' emph1='y'\>  
\>\>उन

\<fs af='उ,pn,any,pl,3,o,ko,ko' emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,ko,ko' emph1='y'\>  
\>\>उन्हें\_भी|उनको\_भी

\<fs af='उ,pn,any,pl,3,o,se,se' emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,se,se' emph1='y'\>  
\>\>उनसे\_भी

\<fs af='उ,pn,any,pl,3,o,meM,meM' emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,meM,meM' emph1='y'\>  
\>\>उनमें\_भी

\<fs af='उ,pn,any,pl,3,o,para,para' emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,para,para' emph1='y'\>  
\>\>उनपर\_भी

\<fs af='इ,pn,any,sg,3,o,0,0' emph1='y'\>  
\<fs af='यह,pn,any,sg,3,o,0,0' emph1='y'\>  
\>\>इस

\<fs af='इ,pn,any,sg,3,o,ko,ko' emph1='y'\>

\<fs af='यह,pn,any,sg,3,o,ko,ko' emph1='y'\>  
\>\>इसे\_भी|इसको\_भी

\<fs af='इ,pn,any,sg,3,o,se,se' emph1='y'\>

\<fs af='यह,pn,any,sg,3,o,se,se' emph1='y'\>  
\>\>इससे\_भी

\<fs af='इ,pn,any,sg,3,o,meM,meM' emph1='y'\>

\<fs af='यह,pn,any,sg,3,o,meM,meM' emph1='y'\>  
\>\>इसमें\_भी

\<fs af='इ,pn,any,sg,3,o,para,para' emph1='y'\>

\<fs af='यह,pn,any,sg,3,o,para,para' emph1='y'\>  
\>\>इसपर\_भी

\<fs af='इ,pn,any,pl,3,o,0,0' emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,0,0' emph1='y'\>  
\>\>इन

\<fs af='इ,pn,any,pl,3,o,ko,ko' emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,ko,ko' emph1='y'\>  
\>\>इन्हें\_भी|इनको\_भी

\<fs af='इ,pn,any,pl,3,o,se,se' emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,se,se' emph1='y'\>  
\>\>इनसे\_भी

\<fs af='इ,pn,any,pl,3,o,meM,meM' emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,meM,meM' emph1='y'\>  
\>\>इनमें\_भी

\<fs af='इ,pn,any,pl,3,o,para,para' emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,para,para' emph1='y'\>  
\>\>इनपर\_भी

\<fs af='जे,pn,any,sg,3,o,0,0' emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,0,0' emph1='y'\>  
\>\>जिस

\<fs af='जे,pn,any,sg,3,o,ko,ko' emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,ko,ko' emph1='y'\>  
\>\>जिसे\_भी|जिसको\_भी

\<fs af='जे,pn,any,sg,3,o,se,se' emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,se,se' emph1='y'\>  
\>\>जिससे\_भी

\<fs af='जे,pn,any,sg,3,o,meM,meM' emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,meM,meM' emph1='y'\>  
\>\>जिसमें\_भी

\<fs af='जे,pn,any,sg,3,o,para,para' emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,para,para' emph1='y'\>  
\>\>जिसपर\_भी

\<fs af='जे,pn,any,pl,3,o,0,0' emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,0,0' emph1='y'\>  
\>\>जिन

\<fs af='जे,pn,any,pl,3,o,ko,ko' emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,ko,ko' emph1='y'\>  
\>\>जिन्हें\_भी|जिनको\_भी

\<fs af='जे,pn,any,pl,3,o,se,se' emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,se,se' emph1='y'\>  
\>\>जिनसे\_भी

\<fs af='जे,pn,any,pl,3,o,meM,meM' emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,meM,meM' emph1='y'\>  
\>\>जिनमें\_भी

\<fs af='जे,pn,any,pl,3,o,para,para' emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,para,para' emph1='y'\>  
\>\>जिनपर\_भी

\<fs af='कवन,pn,any,sg,3,o,0,0' emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,0,0' emph1='y'\>  
\>\>किस

\<fs af='कवन,pn,any,sg,3,o,ko,ko' emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,ko,ko' emph1='y'\>  
\>\>किसे\_भी|किसको\_भी

\<fs af='कवन,pn,any,sg,3,o,se,se' emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,se,se' emph1='y'\>  
\>\>किससे\_भी

\<fs af='कवन,pn,any,sg,3,o,meM,meM' emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,meM,meM' emph1='y'\>  
\>\>किसमें\_भी

\<fs af='कवन,pn,any,sg,3,o,para,para' emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,para,para' emph1='y'\>  
\>\>किसपर\_भी

\<fs af='कवन,pn,any,pl,3,o,0,0' emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,0,0' emph1='y'\>  
\>\>किन

\<fs af='कवन,pn,any,pl,3,o,ko,ko' emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,ko,ko' emph1='y'\>  
\>\>किन्हें\_भी|किनको\_भी

\<fs af='कवन,pn,any,pl,3,o,se,se' emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,se,se' emph1='y'\>  
\>\>किनसे\_भी

\<fs af='कवन,pn,any,pl,3,o,meM,meM' emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,meM,meM' emph1='y'\>  
\>\>किनमें\_भी

\<fs af='कवन,pn,any,pl,3,o,para,para' emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,para,para' emph1='y'\>  
\>\>किनपर\_भी

\<fs af='केहु,pn,any,sg,3,o,0,0' emph1='y'\>

\<fs af='कोई,pn,any,sg,3,o,0,0' emph1='y'\>  
\>\>किसी

\<fs af='केहु,pn,any,sg,3,o,ko,ko' emph1='y'\>

\<fs af='कोई,pn,any,sg,3,o,ko,ko' emph1='y'\>  
\>\>किसी\_को\_भी

\<fs af='केहु,pn,any,sg,3,o,se,se' emph1='y'\>

\<fs af='कोई,pn,any,sg,3,o,se,se' emph1='y'\>  
\>\>किसी\_से\_भी

\<fs af='केहु,pn,any,sg,3,o,meM,meM' emph1='y'\>

\<fs af='कोई,pn,any,sg,3,o,meM,meM' emph1='y'\>  
\>\>किसी\_में\_भी

\<fs af='केहु,pn,any,sg,3,o,para,para' emph1='y'\>

\<fs af='कोई,pn,any,sg,3,o,para,para' emph1='y'\>  
\>\>किसी\_पर\_भी

\<fs af='केहु,pn,any,pl,3,o,0,0' emph1='y'\>

\<fs af='कोई,pn,any,pl,3,o,0,0' emph1='y'\>  
\>\>किन्हीं

\<fs af='केहु,pn,any,pl,3,o,ko,ko' emph1='y'\>

\<fs af='कोई,pn,any,pl,3,o,ko,ko' emph1='y'\>  
\>\>किन्हीं\_को\_भी

\<fs af='केहु,pn,any,pl,3,o,se,se' emph1='y'\>

\<fs af='कोई,pn,any,pl,3,o,se,se' emph1='y'\>  
\>\>किन्ही\_से\_भी

\<fs af='केहु,pn,any,pl,3,o,meM,meM' emph1='y'\>

\<fs af='कोई,pn,any,pl,3,o,meM,meM' emph1='y'\>  
\>\>किन्हीं\_में\_भी

\<fs af='केहु,pn,any,pl,3,o,para,para' emph1='y'\>

\<fs af='कोई,pn,any,pl,3,o,para,para' emph1='y'\>  
\>\>किन्हीं\_पर\_भी

\<fs af='सब,pn,any,pl,3,o,ko,ko' emph1='y'\>

\<fs af='सब,pn,any,pl,3,o,ko,ko' emph1='y'\>  
\>\>सभी\_को

\<fs af='सब,pn,any,pl,3,o,se,se' emph1='y'\>

\<fs af='सब,pn,any,pl,3,o,se,se' emph1='y'\>  
\>\>सभी\_से

\<fs af='सब,pn,any,pl,3,o,meM,meM' emph1='y'\>

\<fs af='सब,pn,any,pl,3,o,meM,meM' emph1='y'\>  
\>\>सभी\_में

\<fs af='सब,pn,any,pl,3,o,para,para' emph1='y'\>

\<fs af='सब,pn,any,pl,3,o,para,para' emph1='y'\>  
\>\>सभी\_पर

\[\[Pro\_spl\_a\]\]

\<fs af='सब,pn,any,pl,3,any,0,0'\>

\<fs af='सब,pn,any,pl,3,any,0,0'\>  
\>\>सब

\[\[Pro\_spl\_a\_e\]\]

\<fs af='सब,pn,any,pl,3,d,0,0' emph='y'\>

\<fs af='सब,pn,any,pl,3,d,0,0' emph='y'\>  
\>\>सब\_ही

\[\[Pro\_spl\_a\_e1\]\]

\<fs af='सब,pn,any,pl,3,d,0,0' emph1='y'\>

\<fs af='सब,pn,any,pl,3,d,0,0' emph1='y'\>  
\>\>सभी

\[\[Pro\_d\_a\]\]

\<fs af='उ,pn,any,sg,3,d,0,0'\>

\<fs af='वह,pn,any,sg,3,d,0,0'\>  
\>\>वह|वो

\<fs af='उ,pn,any,pl,3,d,0,0'\>

\<fs af='वह,pn,any,pl,3,d,0,0'\>  
\>\>वे

\<fs af='जे,pn,any,sg,3,d,0,0'\>

\<fs af='जो,pn,any,sg,3,d,0,0'\>  
\>\>जो

\<fs af='जे,pn,any,pl,3,d,0,0'\>

\<fs af='जो,pn,any,pl,3,d,0,0'\>  
\>\>जो

\<fs af='कवन,pn,any,sg,3,d,0,0'\>

\<fs af='कौन,pn,any,sg,3,d,0,0'\>  
\>\>कौन

\<fs af='कवन,pn,any,pl,3,d,0,0'\>

\<fs af='कौन,pn,any,pl,3,d,0,0'\>  
\>\>कौन

\<fs af='केहु,pn,any,sg,3,d,0,0'\>

\<fs af='कोई,pn,any,sg,3,d,0,0'\>  
\>\>कोई

\<fs af='केहु,pn,any,pl,3,d,0,0'\>

\<fs af='कोई,pn,any,pl,3,d,0,0'\>  
\>\>कोई

\<fs af='इ,pn,any,sg,3,d,0,0'\>

\<fs af='यह,pn,any,sg,3,d,0,0'\>  
\>\>यह

\<fs af='इ,pn,any,pl,3,d,0,0'\>

\<fs af='यह,pn,any,pl,3,d,0,0'\>  
\>\>ये

\[\[Pro\_d\_a\_e\]\]

\<fs af='उ,pn,any,sg,3,d,0,0' emph='y'\>

\<fs af='वह,pn,any,sg,3,d,0,0' emph='y'\>  
\>\>वही|वहीं

\<fs af='इ,pn,any,sg,3,d,0,0' emph='y'\>

\<fs af='यह,pn,any,sg,3,d,0,0' emph='y'\>  
\>\>यही|यहीं

\[\[Pro\_d\_a\_e1\]\]

\<fs af='उ,pn,any,sg,3,d,0,0' emph1='y'\>

\<fs af='वह,pn,any,sg,3,d,0,0' emph1='y'\>  
\>\>वह\_भी

\<fs af='इ,pn,any,sg,3,d,0,0' emph1='y'\>

\<fs af='यह,pn,any,sg,3,d,0,0' emph1='y'\>  
\>\>यह\_भी

\[\[Pro\_o\_a\]\]

\<fs af='सब,pn,any,pl,3,o,0,0'\>

\<fs af='सब,pn,any,pl,3,o,0,0'\>  
\>\>सबों

\[\[RaRTI\_self\]\]

\<fs af='तू,pn,any,any,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  hon='y'\>

\<fs af='आप,pn,any,any,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  hon='y'\>  
\>\>आपका

\<fs af='तू,pn,any,any,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  hon='y'\>

\<fs af='आप,pn,any,any,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  hon='y'\>  
\>\>आपके

\<fs af='तू,pn,any,any,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  hon='y'\>

\<fs af='आप,pn,any,any,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  hon='y'\>  
\>\>आपके

\<fs af='तू,pn,any,any,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  hon='y'\>

\<fs af='आप,pn,any,any,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  hon='y'\>  
\>\>आपके

\<fs af='तू,pn,any,any,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  hon='y'\>

\<fs af='आप,pn,any,any,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  hon='y'\>  
\>\>आपकी

\<fs af='तू,pn,any,any,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  hon='y'\>

\<fs af='आप,pn,any,any,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  hon='y'\>  
\>\>आपकी

\<fs af='तू,pn,any,any,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  hon='y'\>

\<fs af='आप,pn,any,any,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  hon='y'\>  
\>\>आपकी

\<fs af='तू,pn,any,any,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  hon='y'\>

\<fs af='आप,pn,any,any,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  hon='y'\>  
\>\>आपकी

\[\[RaRTI\_u\]\]

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>मेरा

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>मेरे

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
मेरे

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>मेरे

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>मेरी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>मेरी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>मेरी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>मेरी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>हमारा

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>हमारे

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
\>\>हमारे

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>हमारे

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>हमारी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>हमारी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>हमारी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>हमारी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>अपना

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>अपने

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
\>\>अपने

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>अपने

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>अपनी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>अपनी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>अपनी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>अपनी

\[\[RaRTI\_u\_e\]\]

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>मेरा\_ही|मुझीका

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>मेरे\_ही|मुझीके

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>मेरे\_ही|मुझीके

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>मेरे\_ही|मुझीके

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>मेरी\_ही|मुझीकी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>मेरी\_ही|मुझीकी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>मेरी\_ही|मुझीकी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>मेरी\_ही|मुझीकी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>हमारा\_ही|हमींका

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>हमारे\_ही|हमींके

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>हमारे\_ही|हमींके

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>हमारे\_ही|हमींके

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>हमारी\_ही|हमींकी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>हमारी\_ही|हमींकी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>हमारी\_ही|हमींकी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>हमारी\_ही|हमींकी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>अपना\_ही

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>अपने\_ही

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>अपने\_ही

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>अपने\_ही

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>अपनी\_ही

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>अपनी\_ही

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>अपनी\_ही

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>अपनी\_ही

\[\[RaRTI\_u\_e1\]\]

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>मेरा\_भी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>मेरे\_भी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>मेरे\_भी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>मेरे\_भी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>मेरी\_भी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>मेरी\_भी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>मेरी\_भी

\<fs af='हम,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='मैं,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>मेरी\_भी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>हमारा\_भी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>हमारे\_भी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>हमारे\_भी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>हमारे\_भी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>हमारी\_भी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
हमारी\_भी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>हमारी\_भी

\<fs af='हम,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='मैं,pn,any,pl,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>हमारी\_भी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>अपना\_भी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>अपने\_भी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>अपने\_भी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>अपने\_भी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>अपनी\_भी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>अपनी\_भी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>अपनी\_भी

\<fs af='आपन,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='अपना,pn,any,sg,1,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>अपनी\_भी

\[\[RaRTI\_m\]\]

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>तेरा

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>तेरे

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
\>\>तेरे

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>तेरे

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>तेरी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>तेरी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>तेरी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>तेरी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>तुम्हारा

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>तुम्हारे

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='o' agr\_num='sg'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='o' agr\_num='sg'\>  
\>\>तुम्हारे

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>तुम्हारे

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>तुम्हारी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>तुम्हारी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>तुम्हारी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>तुम्हारी

\[\[RaRTI\_m\_e\]\]

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>तेरा\_ही|तुझीका

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>तेरे\_ही|तुझीके

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>तेरे\_ही|तुझीके

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>तेरे\_ही|तुझीके

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>तेरी\_ही|तुझीकी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>तेरी\_ही|तुझीकी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>तेरी\_ही|तुझीकी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>तेरी\_ही|तुझीकी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>तुम्हारा\_ही|तुम्हींका

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>तुम्हारे\_ही|तुम्हींके

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>तुम्हारे\_ही|तुम्हींके

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>तुम्हारे\_ही|तुम्हींके

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>\\  
\>\>तुम्हारी\_ही|तुम्हींकी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>तुम्हारी\_ही|तुम्हींकी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>तुम्हारी\_ही|तुम्हींकी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>तुम्हारी\_ही|तुम्हींकी

\[\[RaRTI\_m\_e1\]\]

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>तेरा\_भी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>तेरे\_भी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>तेरे\_भी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>तेरे\_भी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>तेरी\_भी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>तेरी\_भी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>तेरी\_भी

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='तू,pn,any,sg,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>तेरी\_भी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>तुम्हारा\_भी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>तुम्हारे\_भी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>तुम्हारे\_भी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>तुम्हारे\_भी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>तुम्हारी\_भी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>तुम्हारी\_भी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>तुम्हारी\_भी

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='तू,pn,any,pl,2,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>तुम्हारी\_भी

\[\[RaRTI\_a\]\]

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>उसका

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>उसके

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
\>\>उसके

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>उसके

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>उसकी

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>उसकी

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>उसकी

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>उसकी

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>उनका

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>उनके

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
\>\>उनके

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>उनके

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>उनकी

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>उनकी

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>उनकी

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>उनकी

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>जिसका

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>जिसके

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
\>\>जिसके

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>जिसके

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>जिसकी

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>जिसकी

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>जिसकी

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>जिसकी

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>जिनका

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>जिनके

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
\>\>जिनके

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>जिनके

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>जिनकी

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>जिनकी

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>जिनकी

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>जिनकी

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>किसका

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>किसके

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
\>\>किसके

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>किसके

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>किसकी

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>किसकी

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>किसकी

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>किसकी

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>किनका

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>किनके

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
\>\>किनके

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>किनके

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>किनकी

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>किनकी

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>किनकी

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>किनकी

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>इसका

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>इसके

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
\>\>इसके

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>इसके

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>इसकी

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>इसकी

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>इसकी

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>इसकी

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>इनका

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
इनके

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
\>\>इनके

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>इनके

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>इनकी

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>इनकी

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>इनकी

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>इनकी

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'\>  
\>\>सबका

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'\>  
\>\>सबके

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'\>  
\>\>सबके

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'\>  
\>\>सबके

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'\>  
\>\>सबकी

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'\>  
\>\>सबकी

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'\>  
\>\>सबकी

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'\>  
\>\>सबकी

\[\[RaRTI\_a\_e\]\]

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>उसीका|उसका\_ही

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>उसीके|उसके\_ही

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>उसीके|उसके\_ही

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>उसीके|उसके\_ही

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>उसीकी|उसकी\_ही

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>उसीकी|उसकी\_ही

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>उसीकी|उसकी\_ही

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>उसीकी|उसकी\_ही

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>उन्हींका|उनका\_ही

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>उन्हींके|उनके\_ही

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>उन्हींके|उनके\_ही

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>उन्हींके|उनके\_ही

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>उन्हींकी|उनकी\_ही

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>उन्हींकी|उनकी\_ही

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>उन्हींकी|उनकी\_ही

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>उन्हींकी|उनकी\_ही

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>जिसका\_ही|जिसीका

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>जिसके\_ही|जिसी\_के

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>जिसके\_ही|जिसी\_के

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>जिसके\_ही|जिसी\_के

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>जिसकी\_ही|जिसी\_की

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>जिसकी\_ही|जिसी\_की

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>जिसकी\_ही|जिसी\_की

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>जिसकी\_ही|जिसी\_की

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>जिन्हींका|जिनका\_ही

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>जिन्हींके|जिनके\_ही

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>जिन्हींके|जिनके\_ही

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>जिन्हींके|जिनके\_ही

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>जिन्हींकी|जिनकी\_ही

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>जिन्हींकी|जिनकी\_ही

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>जिन्हींकी|जिनकी\_ही

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>जिन्हींकी|जिनकी\_ही

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>किसीका|किसका\_ही

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>किसीके|किसके\_ही

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>किसीके|किसके\_ही

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>किसीके|किसके\_ही

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>किसीकी|किसकी\_ही

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>किसीकी|किसकी\_ही

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>किसीकी|किसकी\_ही

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>किसीकी|किसकी\_ही

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>किन्हींका|किनका\_ही

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>किन्हींके|किनके\_ही

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>किन्हींके|किनके\_ही

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>किन्हींके|किनके\_ही

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>किन्हींकी|किनकी\_ही

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>किन्हींकी|किनकी\_ही

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>किन्हींकी|किनकी\_ही

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>किन्हींकी|किनकी\_ही

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>इसीका|इसका\_ही

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>इसीके|इसके\_ही

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>इसीके|इसके\_ही

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>इसीके|इसके\_ही

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>इसीकी|इसकी\_ही

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>इसीकी|इसकी\_ही

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>इसीकी|इसकी\_ही

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>इसीकी|इसकी\_ही

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>इन्हींका|इनका\_ही

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>इन्हींके|इनके\_ही

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>इन्हींके|इनके\_ही

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>इन्हींके|इनके\_ही

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>इन्हींकी|इनकी\_ही

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>इन्हींकी|इनकी\_ही

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>इन्हींकी|इनकी\_ही

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>इन्हींकी|इनकी\_ही

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>सबका\_ही

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>सबके\_ही

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>सबके\_ही

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>सबके\_ही

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph='y'\>  
\>\>सबकी\_ही

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph='y'\>  
\>\>सबकी\_ही

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph='y'\>  
\>\>सबकी\_ही

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph='y'\>  
\>\>सबकी\_ही

\[\[RaRTI\_a\_e1\]\]

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>उसका\_भी

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>उसके\_भी

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>उसके\_भी

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>उसके\_भी

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>उसकी\_भी

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>उसकी\_भी

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>उसकी\_भी

\<fs af='उ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='वह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>उसकी\_भी

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>उनका\_भी

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>उनके\_भी

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>उनके\_भी

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>उनके\_भी

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>उनकी\_भी

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>उनकी\_भी

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>उनकी\_भी

\<fs af='उ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='वह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>उनकी\_भी

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>जिसका\_भी

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>जिसके\_भी

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>जिसके\_भी

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>जिसके\_भी

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>जिसकी\_भी

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>जिसकी\_भी

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>जिसकी\_भी

\<fs af='जे,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='जो,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>जिसकी\_भी

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>जिनका\_भी

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>जिनके\_भी

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>जिनके\_भी

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>जिनके\_भी

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>जिनकी\_भी

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
जिनकी\_भी

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>जिनकी\_भी

\<fs af='जे,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='जो,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>जिनकी\_भी

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>किसका\_भी

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>किसके\_भी

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>किसके\_भी

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>किसके\_भी

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>किसकी\_भी

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>किसकी\_भी

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>किसकी\_भी

\<fs af='कवन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='कौन,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>किसकी\_भी

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>किनका\_भी

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>किनके\_भी

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>किनके\_भी

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>किनके\_भी

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>किनकी\_भी

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>किनकी\_भी

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>किनकी\_भी

\<fs af='कवन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='कौन,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>किनकी\_भी

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>इसका\_भी

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>इसके\_भी

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>इसके\_भी

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>इसके\_भी

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>इसकी\_भी

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>इसकी\_भी

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>इसकी\_भी

\<fs af='इ,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='यह,pn,any,sg,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>इसकी\_भी

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>इनका\_भी

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>इनके\_भी

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>इनके\_भी

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>इनके\_भी

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>इनकी\_भी

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>इनकी\_भी

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>इनकी\_भी

\<fs af='इ,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='यह,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>इनकी\_भी

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>सभीका|सबका\_भी

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>सभीके|सबके\_भी

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>सभीके|सबके\_भी

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='m'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>सभीके|सबके\_भी

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='sg'  emph1='y'\>  
\>\>सभीकी|सबकी\_भी

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='d'  agr\_num='pl'  emph1='y'\>  
\>\>सभीकी|सबकी\_भी

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='sg'  emph1='y'\>  
\>\>सभीकी|सबकी\_भी

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>

\<fs af='सब,pn,any,pl,3,o,kA,kA' agr\_gen='f'  agr\_cas='o'  agr\_num='pl'  emph1='y'\>  
\>\>सभीकी|सबकी\_भी

\[\[Pro\_self\]\]

\<fs af='तू,pn,any,any,2,o,0,0' hon='y'\>

\<fs af='आप,pn,any,any,2,o,0,0' hon='y'\>  
\>\>आप

\<fs af='तू,pn,any,any,2,o,ko,ko' hon='y'\>

\<fs af='आप,pn,any,any,2,o,ko,ko' hon='y'\>  
\>\>आपको

\<fs af='तू,pn,any,any,2,o,se,se' hon='y'\>

\<fs af='आप,pn,any,any,2,o,se,se' hon='y'\>  
\>\>आपसे

\<fs af='तू,pn,any,any,2,o,meM,meM' hon='y'\>

\<fs af='आप,pn,any,any,2,o,meM,meM' hon='y'\>  
\>\>आपमें

\<fs af='तू,pn,any,any,2,o,para,para' hon='y'\>

\<fs af='आप,pn,any,any,2,o,para,para' hon='y'\>  
\>\>आपपर

\[\[Pro\_self\_h\]\]

\<fs af='तू,pn,any,any,2,d,,' hon='y'\>

\<fs af='आप,pn,any,any,2,d,,' hon='y'\>  
\>\>आप

\[\[Pro\_self\_e\_h\]\]

\<fs af='तू,pn,any,any,2,d,,' emph='y'  hon='y'\>

\<fs af='आप,pn,any,any,2,d,,' emph='y'  hon='y'\>  
\>\>आपही

\<fs af='तू,pn,any,any,2,o,,' emph='y'  hon='y'\>

\<fs af='आप,pn,any,any,2,o,,' emph='y'  hon='y'\>  
\>\>आपही

\[\[Pro\_self\_e1\_h\]\]

\<fs af='तू,pn,any,any,2,d,,' emph1='y'  hon='y'\>

\<fs af='आप,pn,any,any,2,d,,' emph1='y'  hon='y'\>  
\>\>आप\_भी

\<fs af='तू,pn,any,any,2,o,,' emph1='y'  hon='y'\>

\<fs af='आप,pn,any,any,2,o,,' emph1='y'  hon='y'\>  
\>\>आप\_भी

\[\[Dexis\_Pro\]\]

\<fs af='इ,pn,any,any,3,any,0,0' dexis='y'\>

\<fs af='यह,pn,any,any,3,any,0,0' dexis='y'\>  
\>\>ये

\<fs af='उ,pn,any,any,3,any,0,0' dexis='y'\>

\<fs af='वह,pn,any,any,3,any,0,0' dexis='y'\>  
\>\>वो

\[\[Dexis\_Pro\_e\]\]

\<fs af='इ,pn,any,any,3,any,0,0' dexis='y' emph='y'\>

\<fs af='यह,pn,any,any,3,any,0,0' dexis='y' emph='y'\>  
\>\>यही|ये\_ही

\<fs af='उ,pn,any,any,3,any,0,0' dexis='y' emph='y'\>

\<fs af='वह,pn,any,any,3,any,0,0' dexis='y' emph='y'\>  
\>\>वही|वो\_ही

\[\[Dexis\_Pro\_e1\]\]

\<fs af='इ,pn,any,any,3,any,0,0' dexis='y' emph1='y'\>

\<fs af='यह,pn,any,any,3,any,0,0' dexis='y' emph1='y'\>  
\>\>यह\_भी|ये\_भी

\<fs af='उ,pn,any,any,3,any,0,0' dexis='y' emph1='y'\>

\<fs af='वह,pn,any,any,3,any,0,0' dexis='y' emph1='y'\>  
\>\>वह\_भी|वो\_भी

\[\[Dexis\_Oblq\_Pro\]\]

\<fs af='इ,pn,any,any,3,o,0,0' dexis='y'\>

\<fs af='यह,pn,any,any,3,o,0,0' dexis='y'\>  
\>\>यहाँ\_के

\<fs af='उ,pn,any,any,3,o,0,0' dexis='y'\>

\<fs af='वह,pn,any,any,3,o,0,0' dexis='y'\>  
\>\>वहाँ\_के

\[\[Dexis\_Oblq\_Pro\_e\]\]

\<fs af='इ,pn,any,any,3,o,0,0' dexis='y' emph='y'\>

\<fs af='यह,pn,any,any,3,o,0,0' dexis='y' emph='y'\>  
\>\>यहीं\_के

\<fs af='उ,pn,any,any,3,o,0,0' dexis='y' emph='y'\>

\<fs af='वह,pn,any,any,3,o,0,0' dexis='y' emph='y'\>  
\>\>वहीं\_के

\[\[Dexis\_Oblq\_Pro\_e1\]\]

\<fs af='इ,pn,any,any,3,o,0,0' dexis='y' emph1='y'\>

\<fs af='यह,pn,any,any,3,o,0,0' dexis='y' emph1='y'\>  
\>\>यहाँ\_के\_भी

\<fs af='उ,pn,any,any,3,o,0,0' dexis='y' emph1='y'\>

\<fs af='वह,pn,any,any,3,o,0,0' dexis='y' emph1='y'\>  
\>\>वहाँ\_के\_भी

\[\[Root\]\]

\<fs af='XX,v,any,any,any,,0,0'\>  
\#Root will be substituted  
\>खा  
\#No need to generate  
\>\>खा

\[\[hE\]\]

\<fs af='XX,v,any,sg,1,,hE,hE'\>   
\#Root and TAM will be substituted  
\>है  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>हूँ

\<fs af='XX,v,any,sg,2,,hE,hE'\>   
\#Root and TAM will be substituted  
\>है  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>है

\<fs af='XX,v,any,sg,3,,hE,hE'\>   
\#Root and TAM will be substituted  
\>है  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>है

\<fs af='XX,v,any,pl,1,,hE,hE'\>   
\#Root and TAM will be substituted  
\>है  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>हैं

\<fs af='XX,v,any,pl,2,,hE,hE'\>   
\#Root and TAM will be substituted  
\>है  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>हो

\<fs af='XX,v,any,pl,3,,hE,hE'\>   
\#Root and TAM will be substituted  
\>है  
Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>हैं

\[\[hE\_e\]\]

\#changed in morph  
\#Note-Change person \*1st to 3rd  
\<fs af='XX,v,any,sg,3,,hE,hE' emph='y'\>  
\#Root and TAM will be substituted  
\>है  
\#Step1=Add directly emphatic value with underscore (i.e. emph=hI) to the verb Root  in terms of final verb generation  
\>\>है\_ही

\[\[hE\_e1\]\]

\#changed in morph  
\#Note-Change person \*1st to 3rd  
\<fs af='XX,v,any,sg,3,,hE,hE' emph1='y'\>  
\#Root and TAM will be substituted  
\>है  
\#Step1=Add directly emphatic value with underscore (i.e. emph1=BI) to the verb Root  in terms of final verb generation  
\>\>है\_भी

\[\[hE\_spl\]\]  
\<fs af='XX,v,any,pl,any,,hE,hE'\>  
\#Root and TAM will be substituted  
\>है  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>हों

\[\[hE\_spl\_h\]\]

\<fs af='XX,v,any,sg,2,,hE,hE' hon='y'\>  
\#Root and TAM will be substituted  
\>है  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>हों

\<fs af='XX,v,any,pl,2,,hE,hE' hon='y'\>  
\#Root and TAM will be substituted  
\>है  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>हों

\<fs af='XX,v,any,any,2,,hE,hE' hon='y'\>  
\#Root and TAM will be substituted  
\>है  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>हैं

\[\[rahala\]\]

\<fs af='XX,v,m,sg,1,,WA,WA'\>  
\#Root and TAM will be substituted  
\>था  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>था

\<fs af='XX,v,m,pl,1,,WA,WA'\>  
\#Root and TAM will be substituted  
\>था  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>थे

\<fs af='XX,v,m,sg,2,,WA,WA'\>  
\#Root and TAM will be substituted  
\>था  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>था

\<fs af='XX,v,m,pl,2,,WA,WA'\>  
\#Root and TAM will be substituted  
\>था  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>थे

\<fs af='XX,v,m,sg,3,,WA,WA'\>  
\#Root and TAM will be substituted  
\>था  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>था

\<fs af='XX,v,m,pl,3,,WA,WA'\>  
\#Root and TAM will be substituted  
\>था  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>थे

\<fs af='XX,v,f,sg,1,,WA,WA'\>  
\#Root and TAM will be substituted  
\>था  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>थी

\<fs af='XX,v,f,sg,2,,WA,WA'\>  
\#Root and TAM will be substituted  
\>था  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>थी

\<fs af='XX,v,f,sg,3,,WA,WA'\>  
\#Root and TAM will be substituted  
\>\>था  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>थी

\<fs af='XX,v,f,pl,1,,WA,WA'\>  
\#Root and TAM will be substituted  
\>था  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>थीं

\<fs af='XX,v,f,pl,2,,WA,WA'\>  
\#Root and TAM will be substituted  
\>था  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>थीं

\<fs af='XX,v,f,pl,3,,WA,WA'\>  
\#Root and TAM will be substituted  
\>था  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>थीं

\[\[rahala\_e\]\]

\#Note-Feature Should be corrected as per number and person  
\<fs af='XX,v,any,any,any,,WA,WA' emph='y'\>  
\#Root and TAM will be substituted  
\>था  
\#Step1= Add directly emphatic value with underscore (i.e. emph=hI) to the verb Root  in terms of final verb generation  
\>\>था\_ही

\[\[rahala\_e1\]\]  
\#Note-Feature Should be corrected as per number and person  
\<fs af='XX,v,any,any,any,,WA,WA' emph1='y'\>  
\#Root and TAM will be substituted  
\>था  
\#Step1= Add directly emphatic value with underscore (i.e. emph1=BI) to the verb Root  in terms of final verb generation  
\>\>था\_भी

\[\[kara\]\]  
\<fs af='XX,v,any,any,any,,kara,kara'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Add directly suffix "के" to the verb Root  in terms of final verb generation  
\>\>खा\_के

\[\[kara\_e\]\]

\<fs af='XX,v,any,any,any,,kara,kara' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Add directly suffix "के" to the verb Root  in terms of final verb generation  
\#Step2=Add directly emphatic value with underscore (i.e. emph=hI) to the result of Step1 in terms of final verb generation  
\>\>खा\_के\_ही

\[\[kara\_e1\]\]

\<fs af='XX,v,any,any,any,,kara,kara' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Add directly suffix "के" to the verb Root  in terms of final verb generation  
\#Step2=Add directly emphatic value with underscore (i.e. emph1=BI) to the result of Step1 in terms of final verb generation  
\>\>खा\_के\_भी

\[\[Infinitive\_yeke\]\]

\#Note- Gender and Number agreement will have to do with agreeing NP  
\<fs af='XX,v,m,sg,any,,yeke,yeke'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाना

\<fs af='XX,v,m,pl,any,,yeke,yeke'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाने

\<fs af='XX,v,f,sg,any,,yeke,yeke'\>  
\#Root and TAM will be substituted  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खानी

\<fs af='XX,v,f,pl,any,,yeke,yeke'\>  
\#Root and TAM will be substituted  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खानीं

\[\[Infinitive\_yeke\_e\]\]

\<fs af='XX,v,m,sg,any,,yeke,yeke' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1=Root+TAM  
\#Step2=Add directly emphatic value with underscore (i.e. emph=hI) to the result of Step1 in terms of final verb generation  
\>\>खाना\_ही

\[\[Infinitive\_yeke\_e1\]\]

\#Note-Check feature  
\<fs af='XX,v,any,any,any,,yeke,yeke' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1=Root+TAM  
\#Step2=Add directly emphatic value with underscore (i.e. emph1=BI) to the result of Step1 in terms of final verb generation  
\>\>खाना\_भी

\[\[Gerund\_ba\]\]

\<fs af='XX,v,any,any,any,,ba,ba'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1=Root+TAM  
\>\>खाना

\[\[Gerund\_ba\_e\]\]  
\<fs af='XX,v,any,any,any,,ba,ba' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1=Root+TAM  
\#Step2=Add directly emphatic value with underscore (i.e. emph=hI) to the result of Step1 in terms of final verb generation  
\>\>खाना\_ही

\[\[Gerund\_ba\_e1\]\]

\<fs af='XX,v,any,any,any,,ba,ba' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1=Root+TAM  
\#Step2=Add directly emphatic value with underscore (i.e. emph1=BI) to the result of Step1 in terms of final verb generation  
\>\>खाना\_भी

\[\[optative\_ilA\]\]

\<fs af='XX,v,m,sg,1,,ilA,ilA'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ता\_हूँ  
\>\>खाता\_हूँ

\<fs af='XX,v,m,pl,1,,ilA,ilA'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ते\_हैं  
\>\>खाते\_हैं

\<fs af='XX,v,m,sg,2,,ilA,ilA'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ता\_है  
\>\>खाता\_है

\<fs af='XX,v,m,pl,2,,ilA,ilA'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ते\_हो|ROOT+ते\_हैं  
\>\>खाते\_हो|खाते\_हैं

\<fs af='XX,v,m,sg,3,,ilA,ilA'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ता\_है  
\>\>खाता\_है

\<fs af='XX,v,m,pl,3,,ilA,ilA'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ते\_हैं  
\>\>खाते\_हैं

\<fs af='XX,v,f,sg,1,,ilA,ilA'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ती\_हूँ  
\>\>खाती\_हूँ

\<fs af='XX,v,f,pl,1,,ilA,ilA'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ते\_हैं  
\>\>खाते\_हैं

\<fs af='XX,v,f,sg,2,,ilA,ilA'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ती\_है  
\>\>खाती\_है

\<fs af='XX,v,f,pl,2,,ilA,ilA'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ती\_हो|ROOT+ती\_हैं  
\>\>खाती\_हो|खाती\_हैं

\<fs af='XX,v,f,sg,3,,ilA,ilA'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ती\_है  
\>\>खाती\_है

\<fs af='XX,v,f,pl,3,,ilA,ilA'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ती\_हैं  
\>\>खाती\_हैं

\#If emph='y' is appended   
\<fs af='XX,v,m,sg,1,,ilA,ilA' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ता\_ही\_हूँ  
\>\>खाता\_ही\_हूँ

\<fs af='XX,v,m,pl,1,,ilA,ilA' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ते\_ही\_हैं  
\>\>खाते\_ही\_हैं

\<fs af='XX,v,m,sg,2,,ilA,ilA' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ता\_ही\_है  
\>\>खाता\_ही\_है

\<fs af='XX,v,m,pl,2,,ilA,ilA' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ते\_ही\_हो|ROOT+ते\_ही\_हैं  
\>\>खाते\_ही\_हो|खाते\_ही\_हैं

\<fs af='XX,v,m,sg,3,,ilA,ilA' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ता\_ही\_है  
\>\>खाता\_ही\_है

\<fs af='XX,v,m,pl,3,,ilA,ilA' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ते\_ही\_हैं  
\>\>खाते\_ही\_हैं

\<fs af='XX,v,f,sg,1,,ilA,ilA' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ती\_ही\_हूँ  
\>\>खाती\_ही\_हूँ

\<fs af='XX,v,f,pl,1,,ilA,ilA' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ते\_ही\_हैं  
\>\>खाते\_ही\_हैं

\<fs af='XX,v,f,sg,2,,ilA,ilA' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ती\_ही\_है  
\>\>खाती\_ही\_है

\<fs af='XX,v,f,pl,2,,ilA,ilA' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ती\_ही\_हो|ROOT+ती\_ही\_हैं  
\>\>खाती\_ही\_हो|खाती\_ही\_हैं

\<fs af='XX,v,f,sg,3,,ilA,ilA' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ती\_ही\_है  
\>\>खाती\_ही\_है

\<fs af='XX,v,f,pl,3,,ilA,ilA' emph='y'\>  
\#Root and TAM will be substituted  
\>\>खा  
\#ROOT+ती\_ही\_हैं  
\>\>खाती\_ही\_हैं

\#If emph1='y' is appended   
\<fs af='XX,v,m,sg,1,,ilA,ilA' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ता\_भी\_हूँ  
\>\>खाता\_भी\_हूँ

\<fs af='XX,v,m,pl,1,,ilA,ilA' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ते\_भी\_हैं  
\>\>खाते\_भी\_हैं

\<fs af='XX,v,m,sg,2,,ilA,ilA' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ता\_भी\_है  
\>\>खाता\_भी\_है

\<fs af='XX,v,m,pl,2,,ilA,ilA' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ते\_भी\_हो|ROOT+ते\_भी\_हैं  
\>\>खाते\_भी\_हो|खाते\_भी\_हैं

\<fs af='XX,v,m,sg,3,,ilA,ilA' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ता\_भी\_है  
\>\>खाता\_भी\_है

\<fs af='XX,v,m,pl,3,,ilA,ilA' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ते\_भी\_हैं  
\>\>खाते\_भी\_हैं

\<fs af='XX,v,f,sg,1,,ilA,ilA' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ती\_भी\_हूँ  
\>\>खाती\_भी\_हूँ

\<fs af='XX,v,f,pl,1,,ilA,ilA' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ते\_भी\_हैं  
\>\>खाते\_भी\_हैं

\<fs af='XX,v,f,sg,2,,ilA,ilA' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ती\_भी\_है  
\>\>खाती\_भी\_है

\<fs af='XX,v,f,pl,2,,ilA,ilA' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
ROOT+ती\_भी\_हो|ROOT+ती\_भी\_हैं  
\>\>खाती\_भी\_हो|खाती\_भी\_हैं

\<fs af='XX,v,f,sg,3,,ilA,ilA' emph1='y'\>  
\#Root and TAM will be substituted  
\>\>खा  
\#ROOT+ती\_भी\_है  
\>\>खाती\_भी\_है

\<fs af='XX,v,f,pl,3,,ilA,ilA' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#ROOT+ती\_भी\_हैं  
\>\>खाती\_भी\_हैं

\[\[Optative\_Aux\_ha\]\]

\<fs af='XX,v,any,sg,1,,hE,hE' mood='y'\>  
\#Root and TAM will be substituted  
\>है  
\#Generate directly= हूँ  
\>\>हूँ

\[\[Optative1\_Aux\_ha\]\]

\<fs af='XX,v,any,sg,1,,hE,hE' mood1='y'\>  
\#Root and TAM will be substituted  
\>खा/ समझ  
\#-ता\_हूँ  
\#(Suffix "-ता\_हूँ" will be added to the preceding verb ROOT form in final generation i.e.समझ-ता\_हूँ)   
\>\>खाता\_हूँ/समझता\_हूँ

\[\[subj\]\]

\<fs af='XX,v,any,sg,1,,e,e'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाऊँ

\<fs af='XX,v,any,sg,2,,e,e'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाये

\<fs af='XX,v,any,sg,2,,e,e' hon='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाइये

\<fs af='XX,v,any,sg,3,,e,e'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाये

\<fs af='XX,v,any,pl,1,,e,e'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायें

\<fs af='XX,v,any,pl,2,,e,e'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाओ

\<fs af='XX,v,any,pl,2,,e,e' hon='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाइये

\<fs af='XX,v,any,pl,3,,e,e'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायें

\<fs af='XX,v,any,any,2,,e,e' hon='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायें

\[\[Future\]\]

\<fs af='XX,v,m,sg,1,,gA,gA'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाऊँगा

\<fs af='XX,v,m,sg,2,,gA,gA'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायेगा

\<fs af='XX,v,m,sg,2,,gA,gA' hon='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायेंगे

\<fs af='XX,v,m,sg,3,,gA,gA'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायेगा

\<fs af='XX,v,m,pl,1,,gA,gA'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायेंगे

\<fs af='XX,v,m,pl,2,,gA,gA'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाओगे

\<fs af='XX,v,m,pl,2,,gA,gA' hon='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायेंगे

\<fs af='XX,v,m,pl,3,,gA,gA'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायेंगे

\<fs af='XX,v,f,sg,1,,gA,gA'\>  
\#Root and TAM will be substituted  
\>\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाऊँगी

\<fs af='XX,v,f,sg,2,,gA,gA'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायेगी

\<fs af='XX,v,f,sg,2,,gA,gA' hon='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायेंगी

\<fs af='XX,v,f,sg,3,,gA,gA'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायेगी

\<fs af='XX,v,f,pl,1,,gA,gA'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायेंगी

\<fs af='XX,v,f,pl,2,,gA,gA'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाओगी

\<fs af='XX,v,f,pl,2,,gA,gA' hon='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायेंगी

\<fs af='XX,v,f,pl,3,,gA,gA'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायेंगी

\<fs af='XX,v,any,sg,2,,gA,gA' hon='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाइयेगा

\<fs af='XX,v,any,pl,2,,gA,gA' hon='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाइयेगा

\[\[Future\_e\]\]

\<fs af='XX,v,any,any,any,,gA,gA' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,any,any,any,,gA,gA' emph='y'\> TO \<fs af='XX,v,m,sg,1,,gA,gA' emph='y'\>  
\#Step2=Separate out emph='y'  
\#Step3=Generate remaining morph feature directly through inverted Hindi morph  
\#Step4=Add emphatic value (emph=hI) with underscore in the result of Step3  
\>\>खाऊँगा\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,sg,1,,gA,gA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खाऊँगा\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,sg,2,,gA,gA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खायेगा\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,sg,2,,gA,gA' hon='y' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खायेंगे\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,sg,3,,gA,gA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खायेगा\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,pl,1,,gA,gA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खायेंगे\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,pl,2,,gA,gA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खाओगे\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,pl,2,,gA,gA' hon='y' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खायेंगे\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,pl,3,,gA,gA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खायेंगे\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,sg,1,,gA,gA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खाऊँगी\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,sg,2,,gA,gA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खायेगी\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,sg,2,,gA,gA' hon='y' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खायेंगी\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,sg,3,,gA,gA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खायेगी\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,pl,1,,gA,gA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खायेंगी\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,pl,2,,gA,gA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खाओगी\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,pl,2,,gA,gA' hon='y' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खायेंगी\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,pl,3,,gA,gA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खायेंगी\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,any,sg,2,,gA,gA' hon='y' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खाइयेगा\_ही

\[\[Agr\_based feature\]\]

\<fs af='XX,v,any,pl,2,,gA,gA' hon='y' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph=hI) with underscore in the result of Step2  
\>\>खाइयेगा\_ही

\[\[Future\_e1\]\]

\<fs af='XX,v,any,any,any,,gA,gA' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#\#Step1= Change lexical transferred morph feature \<fs af='XX,v,any,any,any,,gA,gA' emph1='y'\> TO \<fs af='XX,v,m,sg,1,,gA,gA' emph1='y'\>  
\#Step2=Separate out emph1='y'  
\#Step3=Generate remaining morph feature directly through inverted Hindi morph  
\#Step4=Add emphatic value (emph1=BI) with underscore in the result of Step3  
\>\>खाऊँगा\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,sg,1,,gA,gA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खाऊँगा\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,sg,2,,gA,gA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खायेगा\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,sg,2,,gA,gA' hon='y' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खायेंगे\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,sg,3,,gA,gA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खायेगा\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,pl,1,,gA,gA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खायेंगे\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,pl,2,,gA,gA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खाओगे\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,pl,2,,gA,gA' hon='y' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खायेंगे\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,m,pl,3,,gA,gA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खायेंगे\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,sg,1,,gA,gA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खाऊँगी\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,sg,2,,gA,gA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खायेगी\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,sg,2,,gA,gA' hon='y' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खायेंगी\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,sg,3,,gA,gA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खायेगी\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,pl,1,,gA,gA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खायेंगी\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,pl,2,,gA,gA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खाओगी\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,pl,2,,gA,gA' hon='y' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खायेंगी\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,f,pl,3,,gA,gA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खायेंगी\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,any,sg,2,,gA,gA' hon='y' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खाइयेगा\_भी

\[\[Agr\_based feature\]\]

\<fs af='XX,v,any,pl,2,,gA,gA' hon='y' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaining morph feature directly through inverted Hindi morph  
\#Step3=Add emphatic value (emph1=BI) with underscore in the result of Step2  
\>\>खाइयेगा\_भी

\[\[PstPerf\_Plus\_Aux\_yale1\]\]

\<fs af='XX,v,any,any,any,,yale1,yale1'\>  
\#Root and TAM will be substituted  
\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,any,any,any,,yA1,yA1'\> TO \<fs af='XX,v,m,sg,any,,yA1,yA1'\>  
\#Step2=Generate changed morph feature directly through inverted Hindi morph  
\>\>गया

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,sg,any,,yA1,yA1'\>  
\>जा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>गया

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,pl,any,,yA1,yA1'\>  
\>जा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>गये

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,sg,any,,yA1,yA1'\>  
\>जा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>गयी

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,pl,any,,yA1,yA1'\>  
\>जा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>गयीं

\[\[PstPerf\_Plus\_Aux\_yale\]\]

\<fs af='xx,v,any,any,any,,yale,yale'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='xx,v,any,any,any,,yA,yA'\> TO \<fs af='xx,v,m,sg,any,,yA,yA'\>  
\#Step2=Generate changed morph feature directly through inverted Hindi morph  
\>\>खाया

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,sg,any,,yA,yA'\>  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाया

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,pl,any,,yA,yA'\>  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खाये

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,sg,any,,yA,yA'\>  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायी

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,pl,any,,yA,yA'\>  
\>खा  
\#Direct Word Generation Through Inverted Hindi Morph Analyser (i.e. Morph feature to word)  
\>\>खायीं

\[\[PstPerf\_Plus\_Aux\_e\_yale\]\]

\<fs af='XX,v,any,any,any,,yale,yale' emph='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='xx,v,any,any,any,,yA,yA' emph='y'\> TO \<fs af='xx,v,m,sg,any,,yA,yA' emph='y'\>  
\#Step2=Separate out emph='y'  
\#Step3=Generate remaing  morph feature directly through inverted Hindi morph  
\#Step4= Add emphatic value (emph=hI) with underscore to the result of Step3  
\>\>खाया\_ही

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,sg,any,,yA,yA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaing  morph feature directly through inverted Hindi morph  
\#Step3= Add emphatic value (emph=hI) with underscore to the result of Step2  
\>\>खाया\_ही

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,pl,any,,yA,yA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaing  morph feature directly through inverted Hindi morph  
\#Step3= Add emphatic value (emph=hI) with underscore to the result of Step2  
\>\>खाये\_ही

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,sg,any,,yA,yA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaing  morph feature directly through inverted Hindi morph  
\#Step3= Add emphatic value (emph=hI) with underscore to the result of Step2  
\>\>खायी\_ही

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,pl,any,,yA,yA' emph='y'\>  
\>खा  
\#Step1=Separate out emph='y'  
\#Step2=Generate remaing  morph feature directly through inverted Hindi morph  
\#Step3= Add emphatic value (emph=hI) with underscore to the result of Step2  
\>\>खायीं\_ही

\[\[PstPerf\_Plus\_Aux\_e1\_yale\]\]

\<fs af='XX,v,any,any,any,,yale,yale' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='xx,v,any,any,any,,yA,yA' emph1='y'\> TO \<fs af='xx,v,m,sg,any,,yA,yA' emph1='y'\>  
\#Step2=Separate out emph1='y'  
\#Step3=Generate remaing  morph feature directly through inverted Hindi morph  
\#Step4= Add emphatic value (emph1=BI) with underscore to the result of Step3  
\>\>खाया\_भी

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,sg,any,,yA,yA' emph1='y'\>  
\>खा  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaing  morph feature directly through inverted Hindi morph  
\#Step3= Add emphatic value (emph1=BI) with underscore to the result of Step2  
\>\>खाया\_भी

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,pl,any,,yA,yA' emph1='y'\>  
\#Step1=Separate out emph1='y'  
Step2=Generate remaing  morph feature directly through inverted Hindi morph  
\#Step3= Add emphatic value (emph1=BI) with underscore to the result of Step2  
\>\>खाये\_भी

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,sg,any,,yA,yA' emph1='y'\>  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaing  morph feature directly through inverted Hindi morph  
\#Step3= Add emphatic value (emph1=BI) with underscore to the result of Step2  
\>\>खायी\_भी

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,pl,any,,yA,yA' emph1='y'\>  
\#Step1=Separate out emph1='y'  
\#Step2=Generate remaing  morph feature directly through inverted Hindi morph  
\#Step3= Add emphatic value (emph1=BI) with underscore to the result of Step2  
\>\>खायीं\_भी

\[\[PstPerf\_Minus\_Aux\_ila\]\]

\<fs af='XX,v,m,sg,1,,ila,ila'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,m,sg,1,,yA,yA'\> TO \<fs af='XX,v,m,sg,any,,yA,yA'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>खाया

\<fs af='XX,v,m,pl,1,,ila,ila'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,m,pl,1,,yA,yA'\> TO \<fs af='XX,v,m,pl,any,,yA,yA'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>खाये

\<fs af='XX,v,m,sg,2,,ila,ila'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,m,sg,2,,yA,yA'\> TO \<fs af='XX,v,m,sg,any,,yA,yA'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>खाया

\<fs af='XX,v,m,pl,2,,ila,ila'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,m,pl,2,,yA,yA'\> TO \<fs af='XX,v,m,pl,any,,yA,yA'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>खाये

\<fs af='XX,v,m,sg,3,,ila,ila'\>  
\#Root and TAM will be substituted  
खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,m,sg,3,,yA,yA'\> TO \<fs af='XX,v,m,sg,any,,yA,yA'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>खाया

\<fs af='XX,v,m,pl,3,,ila,ila'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,m,pl,3,,yA,yA'\> TO \<fs af='XX,v,m,pl,any,,yA,yA'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>खाये

\<fs af='XX,v,f,sg,1,,ila,ila'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,f,sg,1,,yA,yA'\> TO \<fs af='XX,v,f,sg,any,,yA,yA'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>खायी

\<fs af='XX,v,f,pl,1,,ila,ila'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,f,pl,1,,yA,yA'\> TO \<fs af='XX,v,f,pl,any,,yA,yA'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>खायीं

\<fs af='XX,v,f,sg,2,,ila,ila'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,f,sg,2,,yA,yA'\> TO \<fs af='XX,v,f,sg,any,,yA,yA'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>खायी

\<fs af='XX,v,f,pl,2,,ila,ila'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,f,pl,2,,yA,yA'\> TO \<fs af='XX,v,f,pl,any,,yA,yA'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>खायीं

\<fs af='XX,v,f,sg,3,,ila,ila'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,f,sg,3,,yA,yA'\> TO \<fs af='XX,v,f,sg,any,,yA,yA'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>खायी

\<fs af='XX,v,f,pl,3,,ila,ila'\>  
\#Root and TAM will be substituted  
\>\>खा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,f,pl,3,,yA,yA'\> TO \<fs af='XX,v,f,pl,any,,yA,yA'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>खायीं

\[PstPerf\_Minus\_Aux\_ila1\]\]

\<fs af='XX,v,m,sg,1,,ila1,ila1'\>  
\#Root and TAM will be substituted  
\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,m,sg,1,,yA1,yA1'\> TO \<fs af='XX,v,m,sg,any,,yA1,yA1'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>गया

\<fs af='XX,v,m,pl,1,,ila1,ila1'\>  
\#Root and TAM will be substituted  
\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,m,pl,1,,yA1,yA1'\> TO \<fs af='XX,v,m,pl,any,,yA1,yA1'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>गये

\<fs af='XX,v,m,sg,2,,ila1,ila1'\>  
\#Root and TAM will be substituted  
\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,m,sg,2,,yA1,yA1'\> TO \<fs af='XX,v,m,sg,any,,yA1,yA1'\>  
\>\>Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>गया

\<fs af='XX,v,m,pl,2,,ila1,ila1'\>  
\#Root and TAM will be substituted  
\>\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,m,pl,2,,yA1,yA1'\> TO \<fs af='XX,v,m,pl,any,,yA1,yA1'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>गये

\<fs af='XX,v,m,sg,3,,ila1,ila1'\>  
\#Root and TAM will be substituted  
\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,m,sg,3,,yA1,yA1'\> TO \<fs af='XX,v,m,sg,any,,yA1,yA1'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>गया

\<fs af='XX,v,m,pl,3,,ila1,ila1'\>  
\#Root and TAM will be substituted  
\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,m,pl,3,,yA1,yA1'\> TO \<fs af='XX,v,m,pl,any,,yA1,yA1'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>गये

\<fs af='XX,v,f,sg,1,,ila1,ila1'\>  
\#Root and TAM will be substituted  
\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,f,sg,1,,yA1,yA1'\> TO \<fs af='XX,v,f,sg,any,,yA1,yA1'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>गयी

\<fs af='XX,v,f,pl,1,,ila1,ila1'\>  
\#Root and TAM will be substituted  
\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,f,pl,1,,yA1,yA1'\> TO \<fs af='XX,v,f,pl,any,,yA1,yA1'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>गयीं

\<fs af='XX,v,f,sg,2,,ila1,ila1'\>  
\#Root and TAM will be substituted  
\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,f,sg,2,,yA1,yA1'\> TO \<fs af='XX,v,f,sg,any,,yA1,yA1'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>गयी

\<fs af='XX,v,f,pl,2,,ila1,ila1'\>  
\#Root and TAM will be substituted  
\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,f,pl,2,,yA1,yA1'\> TO \<fs af='XX,v,f,pl,any,,yA1,yA1'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>गयीं

\<fs af='XX,v,f,sg,3,,ila1,ila1'\>  
\#Root and TAM will be substituted  
\>\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,f,sg,3,,yA1,yA1'\> TO \<fs af='XX,v,f,sg,any,,yA1,yA1'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>गयी

\<fs af='XX,v,f,pl,3,,ila1,ila1'\>  
\#Root and TAM will be substituted  
\>जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,f,pl,3,,yA1,yA1'\> TO \<fs af='XX,v,f,pl,any,,yA1,yA1'\>  
\#Step2= Generate converted morph feature directly through inverted Hindi morph  
\>\>गयीं

\[\[Pst\_Perf\_Prtcpl\_yala\]\]

\<fs af='XX,v,any,any,any,,yala,yala'\>  
\#Root and TAM will be substituted  
\>खा  
\#Step1= Change lexical transferred morph feature   
\<fs af='XX,v,any,any,any,,yA\_huA,yA\_huA'\> TO  \<fs af='XX,v,m,sg,any,,yA\_huA,yA\_huA'\>  
\#Step2= Separate out "\_huA" from TAM field  
\#Step3=  Generate remaining morph feature directly through inverted Hindi morph  
Step4= Add "\_huA" to the result of Step3 in terms of final generation  
\#खाया\_हुआ

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,sg,any,,yA\_huA,yA\_huA'\>  
\>खा  
\#Step1= Separate out "\_huA" from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huA" to the result of Step2 in terms of final generation  
\>खाया\_हुआ

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,pl,any,,yA\_huA,yA\_huA'\>  
\>खा  
\#Step1= Separate out "\_huA" from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huye" to the result of Step2 in terms of final generation  
\>\>खाये\_हुये

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,sg,any,,yA\_huA,yA\_huA'\>  
\>खा  
\#Step1= Separate out "\_huA" from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huyI" to the result of Step2 in terms of final generation  
\>\>खायी\_हुयी

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,pl,any,,yA\_huA,yA\_huA'\>  
\>खा  
\#Step1= Separate out "\_huA" from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huyI" to the result of Step2 in terms of final generation  
\>\>खायीं\_हुयी

\[\[Pst\_Perf\_Prtcpl\_yala1\]\]

\<fs af='XX,v,any,any,any,,yala1,yala1'\>  
\#Root and TAM will be substituted  
\>जा  
\#Step1= Change lexical transferred morph feature  \<fs af='XX,v,any,any,any,,yA1\_huA,yA1\_huA'\> TO  \<fs af='XX,v,m,sg,any,,yA1\_huA,yA1\_huA'\>  
\#Step2= Separate out "\_huA" from TAM field  
\#Step3=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step4= Add "\_huA" to the result of Step3 in terms of final generation  
\>\>गया\_हुआ

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,sg,any,,yA1\_huA,yA1\_huA'\>  
\>जा  
\#Step1= Separate out "\_huA" from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huA" to the result of Step2 in terms of final generation  
\>\>गया\_हुआ

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,pl,any,,yA1\_huA,yA1\_huA'\>  
\>जा  
\#Step1= Separate out "\_huA" from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huye" to the result of Step2 in terms of final generation  
\>\>गये\_हुये

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,sg,any,,yA1\_huA,yA1\_huA'\>  
\>जा  
\#Step1= Separate out "\_huA" from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huyI" to the result of Step2 in terms of final generation  
\>\>गयी\_हुयी

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,pl,any,,yA1\_huA,yA1\_huA'\>  
\>जा  
\#Step1= Separate out "\_huA" from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\>Step3= Add "\_huyI" to the result of Step2 in terms of final generation  
\>\>गयीं\_हुयी

\[\[Pres\_Prtcpl\_wa1\]\]

\<fs af='XX,v,any,any,any,,wa1,wa1'\>  
\#Root and TAM will be substituted  
\>खा/जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,any,any,any,,wA\_huA,wA\_huA'\> TO  \<fs af='XX,v,m,sg,any,,wA\_huA,wA\_huA'\>  
\#Step2= Separate out "\_huA" from TAM field  
\#Step3=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step4= Add "\_huA" to the result of Step3 in terms of final generation  
\>\>खाता\_हुआ/जाता\_हुआ

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,sg,any,,wA\_huA,wA\_huA'\>  
\>खा/जा  
\#Step1= Separate out "\_huA" from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huA" to the result of Step2 in terms of final generation  
\>\>खाता\_हुआ/जाता\_हुआ

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,pl,any,,wA\_huA,wA\_huA'\>  
\>खा/जा  
\#Step1= Separate out "\_huA" from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huye" to the result of Step2 in terms of final generation  
\>\>खाते\_हुये/जाते\_हुये

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,sg,any,,wA\_huA,wA\_huA'\>  
\>खा/जा  
\#Step1= Separate out "\_huA" from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huyI" to the result of Step2 in terms of final generation  
\>\>जाती\_हुयी/खाती\_हुयी

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,pl,any,,wA\_huA,wA\_huA'\>  
\>खा/जा  
\#Step1= Separate out "\_huA" from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huyI" to the result of Step2 in terms of final generation  
\>\>जातीं\_हुयी/खातीं\_हुयी

\[\[Pres\_Prtcpl\_e\_wa1\]\]

\<fs af='XX,v,any,any,any,,wa1,wa1'emph='y'\>  
\#Root and TAM will be substituted  
\>खा/जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,any,any,any,,wA\_huA,wA\_huA'emph='y'\> TO  \<fs af='XX,v,m,sg,any,,wA\_huA,wA\_huA'emph='y'\>  
\#Step2= Separate out "\_huA" and emph='y' from TAM field  
\#Step3=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step4= Add "\_huA\_hI" to the result of Step3 in terms of final generation  
\>\>खाता\_हुआ\_ही/जाता\_हुआ\_ही

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,sg,any,,wA\_huA,wA\_huA'emph='y'\>  
\>खा/जा  
\#Step1= Separate out "\_huA" and emph='y' from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huA\_hI" to the result of Step2 in terms of final generation  
\>\>खाता\_हुआ\_ही/जाता\_हुआ\_ही

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,pl,any,,wA\_huA,wA\_huA'emph='y'\>  
\>खा/जा  
\#Step1= Separate out "\_huA" and emph='y' from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huye\_hI" to the result of Step2 in terms of final generation  
\>\>खाते\_हुये\_ही/जाते\_हुये\_ही

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,sg,any,,wA\_huA,wA\_huA'emph='y'\>  
\>खा/जा  
\#Step1= Separate out "\_huA" and emph='y' from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huyI\_hI" to the result of Step2 in terms of final generation  
\>\>जाती\_हुयी\_ही/खाती\_हुयी\_ही

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,pl,any,,wA\_huA,wA\_huA'emph='y'\>  
\>खा/जा  
\#Step1= Separate out "\_huA" and emph='y' from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huyI\_hI" to the result of Step2 in terms of final generation  
\>\>जातीं\_हुयी\_ही/खातीं\_हुयी\_ही

\[\[Pres\_Prtcpl\_e1\_wa1\]\]

\<fs af='XX,v,any,any,any,,wa1,wa1'emph1='y'\>  
\#Root and TAM will be substituted  
\>खा/जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,any,any,any,,wA\_huA,wA\_huA' emph1='y'\> TO  \<fs af='XX,v,m,sg,any,,wA\_huA,wA\_huA' emph1='y'\>  
\#Step2= Separate out "\_huA" and emph1='y' from TAM field  
\#Step3=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step4= Add "\_huA\_BI" to the result of Step3 in terms of final generation  
\>\>खाता\_हुआ\_भी/जाता\_हुआ\_भी

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,sg,any,,wA\_huA,wA\_huA'emph1='y'\>  
\>खा/जा  
\#Step1= Separate out "\_huA" and emph1='y' from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huA\_BI" to the result of Step2 in terms of final generation  
\>\>खाता\_हुआ\_भी/जाता\_हुआ\_भी

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,pl,any,,wA\_huA,wA\_huA'emph1='y'\>  
\>खा/जा  
\#Step1= Separate out "\_huA" and emph1='y' from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huye\_BI" to the result of Step2 in terms of final generation  
\>\>खाते\_हुये\_भी/जाते\_हुये\_भी

\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,sg,any,,wA\_huA,wA\_huA'emph1='y'\>  
\>खा/जा  
\#Step1= Separate out "\_huA" and emph1='y' from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huyI\_BI" to the result of Step2 in terms of final generation  
\>\>जाती\_हुयी\_भी/खाती\_हुयी\_भी

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,pl,any,,wA\_huA,wA\_huA'emph1='y'\>  
\>खा/जा  
\#Step1= Separate out "\_huA" and emph1='y' from TAM field  
\#Step2=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step3= Add "\_huyI\_BI" to the result of Step2 in terms of final generation  
\>\>जातीं\_हुयी\_भी/खातीं\_हुयी\_भी

\[\[Pres\_Prtcpl\_rdp\_wai1\]\]

\<fs af='XX,v,any,any,any,,wai1,wai1' rdp='y'\>  
\#Root and TAM will be substituted  
\>खा/जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,any,any,any,,wA\_huA,wA\_huA' rdp='y'\> TO  \<fs af='XX,v,m,pl,any,,wA\_huA,wA\_huA' rdp='y'\>  
\#Step2= Remove "\_huA" from TAM field and Separate out  rdp='y'   
\#Step3=  Generate remaining morph feature directly through inverted Hindi morph  
\#Step4= For the value of rdp='y'--Make duplicate copy of Step3 result and conjoin the duplicated copy to the result of  Step3 with hyphen  
\>\>खाते-खाते/जाते-जाते

\[\[Pres\_Prog\_Asp\_wa\]\]

\<fs af='XX,v,any,any,any,,wa,wa'\>  
\#Root and TAM will be substituted  
\>खा/जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,any,any,any,,rahA,rahA'\> TO \<fs af='XX,v,m,sg,any,,rahA,rahA'\>  
\#Step2= Root\_rahA  
\>\>खा\_रहा/जा\_रहा

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,sg,any,,rahA,rahA'\>  
\>खा/जा  
\#Step1=Root\_rahA  
\>\>खा\_रहा/जा\_रहा

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,pl,any,,rahA,rahA'\>  
\>खा/जा  
\#Step1=Root\_rahe  
\>\>खा\_रहे/जा\_रहे

\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,sg,any,,rahA,rahA'\>  
\>खा/जा  
\#Step1=Root\_rahI  
\>\>खा\_रही/जा\_रही

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,pl,any,,rahA,rahA'\>  
\>खा/जा  
\#Step1=Root\_rahIM  
\>\>खा\_रहीं/जा\_रहीं

\[\[Pres\_Prog\_Asp\_e\_wa\]\]

\<fs af='XX,v,any,any,any,,wa,wa' emph='y'\>  
\#Root and TAM will be substituted  
\>खा/जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,any,any,any,,rahA,rahA' emph='y'\> TO \<fs af='XX,v,m,sg,any,,rahA,rahA' emph='y'\>  
\#Step2= Root\_hI\_rahA  
\>\>खा\_ही\_रहा/जा\_ही\_रहा

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,sg,any,,rahA,rahA' emph='y'\>  
\>खा/जा  
\#Step1=Root\_hI\_rahA  
\>\>खा\_ही\_रहा/जा\_ही\_रहा

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,pl,any,,rahA,rahA' emph='y'\>  
\>खा/जा  
\#Step1=Root\_hI\_rahe  
\>\>खा\_ही\_रहे/जा\_ही\_रहे

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,sg,any,,rahA,rahA' emph='y'\>  
\>खा/जा  
\#Step1=Root\_hI\_rahI  
\>\>खा\_ही\_रही/जा\_ही\_रही

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,pl,any,,rahA,rahA' emph='y'\>  
\>खा/जा  
\#Step1=Root\_hI\_rahIM  
\>\>खा\_ही\_रहीं/जा\_ही\_रहीं

\[\[Pres\_Prog\_Asp\_e1\_wa\]\]

\<fs af='XX,v,any,any,any,,wa,wa' emph1='y'\>  
\#Root and TAM will be substituted  
\>खा/जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,any,any,any,,rahA,rahA' emph1='y'\> TO \<fs af='XX,v,m,sg,any,,rahA,rahA' emph1='y'\>  
\#Step2= Root\_BI\_rahA  
\>\>खा\_भी\_रहा/जा\_भी\_रहा

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,sg,any,,rahA,rahA' emph1='y'\>  
\>खा/जा  
\#Step1=Root\_BI\_rahA  
\>\>खा\_भी\_रहा/जा\_भी\_रहा

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,m,pl,any,,rahA,rahA' emph1='y'\>  
\>खा/जा  
\#Step1=Root\_BI\_rahe  
\>\>खा\_भी\_रहे/जा\_भी\_रहे

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,sg,any,,rahA,rahA' emph1='y'\>  
\>खा/जा  
\#Step1=Root\_BI\_rahI  
\>\>खा\_भी\_रही/जा\_भी\_रही

\[\[Agr\_based\_feature\]\]

\<fs af='XX,v,f,pl,any,,rahA,rahA' emph1='y'\>  
\>खा/जा  
\#Step1=Root\_BI\_rahIM  
\>\>खा\_भी\_रहीं/जा\_भी\_रहीं

\[\[Pres\_Prog\_Asp\_Aux\_A\]\]

\<fs af='XX,v,m,sg,1,,A,A'\>  
\#Root and TAM will be substituted  
\>रहा (specific)  
\#Step1= iff\<fs af='rahA,v,m,sg,1,,hE,hE'\> then generate\> rAhA+hUz  
\>\>रहा\_हूँ

\<fs af='XX,v,m,pl,1,,A,A'\>  
\#Root and TAM will be substituted  
\>रहा (specific)  
\#Step1= iff\<fs af='rahA,v,m,pl,1,,hE,hE'\> then generate\> rAhe+hEM  
\>\>रहे\_हैं

\<fs af='XX,v,m,sg,2,,A,A'\>  
\#Root and TAM will be substituted  
\>रहा (specific)  
\#Step1= iff\<fs af='rahA,v,m,sg,2,,hE,hE'\> then generate\> rAhA+hE  
\>\>रहा\_है

\<fs af='XX,v,m,pl,2,,A,A'\>  
\#Root and TAM will be substituted  
\>रहा (specific)  
\#Step1= iff\<fs af='rahA,v,m,pl,2,,hE,hE'\> then generate\> rAhe+ho  
\>\>रहे\_हो

\<fs af='XX,v,m,sg,3,,A,A'\>  
\#Root and TAM will be substituted  
\>रहा (specific)  
\#Step1= iff\<fs af='rahA,v,m,sg,3,,hE,hE'\> then generate\> rAhA+hE  
\>\>रहा\_है

\<fs af='XX,v,m,pl,3,,A,A'\>  
\#Root and TAM will be substituted  
\>रहा (specific)  
\#Step1= iff\<fs af='rahA,v,m,pl,3,,hE,hE'\> then generate\> rAhe+hEM  
\>\>रहे\_हैं

\<fs af='XX,v,f,sg,1,,A,A'\>  
\#Root and TAM will be substituted  
\>रहा (specific)  
\#Step1= iff\<fs af='rahA,v,f,sg,1,,hE,hE'\> then generate\> rAhI+hUz  
\>\>रही\_हूँ

\<fs af='XX,v,f,pl,1,,A,A'\>  
\#Root and TAM will be substituted  
\>रहा (specific)  
\#Step1= iff\<fs af='rahA,v,f,pl,1,,hE,hE'\> then generate\> rAhe+hEM  
\>\>रहे\_हैं

\<fs af='XX,v,f,sg,2,,A,A'\>  
\#Root and TAM will be substituted  
\>रहा (specific)  
\#Step1= iff\<fs af='rahA,v,f,sg,2,,hE,hE'\> then generate\> rAhI+hE  
\>\>रही\_है

\<fs af='XX,v,f,pl,2,,A,A'\>  
\#Root and TAM will be substituted  
\>रहा (specific)  
\#Step1= iff\<fs af='rahA,v,f,pl,2,,hE,hE'\> then generate\> rAhI+ho  
\>\>रही\_हो

\<fs af='XX,v,f,sg,3,,A,A'\>  
\#Root and TAM will be substituted  
\>रहा (specific)  
\#Step1= iff\<fs af='rahA,v,f,sg,3,,hE,hE'\> then generate\> rAhI+hE  
\>\>रही\_है

\<fs af='XX,v,f,pl,3,,A,A'\>  
\#Root and TAM will be substituted  
\>रहा (specific)  
\#Step1= iff\<fs af='rahA,v,f,sg,3,,hE,hE'\> then generate\> rAhI+hEM  
\>\>रही\_हैं

\[\[Asp\_Habitual\_ala\]\]

\<fs af='XX,v,any,any,any,,ala,ala'\>  
\#Root and TAM will be substituted  
\>खा/जा  
\#Step1= Change lexical transferred morph feature \<fs af='XX,v,any,any,any,,yA\_asp,yA\_asp'\> TO \<fs af='XX,v,any,any,any,,yA,yA' asp="y"\>  
\#Step2=Generate changed morph feature directly through inverted Hindi morph  
\>\>खाया/जाया

\[\[Adv\_Time\_e\_wai\]\]

\<fs af='XX,v,any,any,any,,wai,wai' emph= 'y'\>  
\#Root and TAM will be substituted  
\>खा/जा  
\#Step1= If \<fs af='XX,v,any,any,any,,we\_hI,we\_hI' emph= 'y'\> then generate Root+we\_hI  
\>\>खाते\_ही/जाते\_ही

\[\[hE\_neg\]\]

\<fs af='XX,v,any,sg,1,,hE,hE' neg='y'\>   
\#Root and TAM will be substituted  
\>है  
\#Step1= Separate out neg='y'  
\#Step 2= Send remaining morph feature to inverted Hindi morph  
\#Step3= Add neg value (neg=nahIM) just before to the result of Step2 with underscore  
\>\>नहीं\_हूँ

\<fs af='XX,v,any,sg,2,,hE,hE' neg='y'\>   
\#Root and TAM will be substituted  
\>है  
\#Step1= Separate out neg='y'  
\#Step 2= Send remaining morph feature to inverted Hindi morph  
\#Step3= Add neg value (neg=nahIM) just before to the result of Step2 with underscore  
\>\>नहीं\_है

\<fs af='XX,v,any,sg,3,,hE,hE' neg='y'\>   
\#Root and TAM will be substituted  
\>है  
\#Step1= Separate out neg='y'  
\#Step 2= Send remaining morph feature to inverted Hindi morph  
\#Step3= Add neg value (neg=nahIM) just before to the result of Step2 with underscore  
\>\>नहीं\_है

\<fs af='XX,v,any,pl,1,,hE,hE' neg='y'\>   
\#Root and TAM will be substituted  
\>है  
\#Step1= Separate out neg='y'  
\#Step 2= Send remaining morph feature to inverted Hindi morph  
\#Step3= Add neg value (neg=nahIM) just before to the result of Step2 with underscore  
\>\>नहीं\_हैं

\<fs af='XX,v,any,pl,2,,hE,hE' neg='y'\>   
\#Root and TAM will be substituted  
\>है  
\#Step1= Separate out neg='y'  
\#Step 2= Send remaining morph feature to inverted Hindi morph  
\#Step3= Add neg value (neg=nahIM) just before to the result of Step2 with underscore  
\>\>नहीं\_हो

\<fs af='XX,v,any,pl,3,,hE,hE' neg='y'\>   
\#Root and TAM will be substituted  
\>है  
\#Step1= Separate out neg='y'  
\#Step 2= Send remaining morph feature to inverted Hindi morph  
\#Step3= Add neg value (neg=nahIM) just before to the result of Step2 with underscore  
\>\>नहीं\_हैं

\[\[\[TAM Dict from B\_M\_M (SL) to Hindi (TL)\]\]\]

\[SL	TL\]  
gA	gA  
e	e  
kara	kara  
ba	nA  
yeke	nA  
ilA	wA\_hE  
wa	rahA  
wa1	wA\_huA  
wai	we\_hI  
wai1	wA\_huA  
ala	yA\_asp  
yala1	yA1\_huA  
yala	yA\_huA  
A	 hE  
ila	yA  
ila1	yA1  
yale	 yA  
yale1	yA1  
WA	WA  
hE	hE  
kA	kA  
ko	ko  
se	se  
meM	meM  
para	para

\[\[\[New Morph Category to Implement\]\]\]  
\#\#Morph category  
\#\#Morph Output  
hE\_neg  
ह

नहनि/नहनी/नइखे/नैखे/नइखी/नइखि/नइखीं/नइखिं  
\<fs af='ह,v,any,sg,1,,hE,hE' neg='y'\>  
नहनि/नहनी/नइखे/नैखे  
\<fs af='ह,v,any,sg,2,,hE,hE' neg='y'\>  
नहनि/नहनी/नइखे/नैखे  
\<fs af='ह,v,any,sg,3,,hE,hE' neg='y'\>  
नहनि/नहनी/नइखे/नैखे/नइखी/नइखि/नइखीं/नइखिं  
\<fs af='ह,v,any,pl,1,,hE,hE' neg='y'\>  
नहनि/नहनी/नइखे/नैखे/नइखी/नइखि/नइखीं/नइखिं  
\<fs af='ह,v,any,pl,2,,hE,hE' neg='y'\>  
नहनि/नहनी/नइखे/नैखे  
\<fs af='ह,v,any,pl,3,,hE,hE' neg='y'\>