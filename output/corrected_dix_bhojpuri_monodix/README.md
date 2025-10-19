the file "bhojpuri-monodix_updated_with pardefs and sdefs" is the modified file with proper sdefs and pardefs defined along with correct alphabets and this is thus made fit for compiling 
(the original file , ouput/bhojpuri-monodix.dix was unfit for compiling)  

still the output obtained by the analysis command:     ```  echo adZaSaTano  | lt-proc  bhoj.automorf.bin ```  on "bhojpuri-monodix_updated_with pardefs and sdefs.dix" produced the following output :  ``` ^adZaSaTano/*adZaSaTano$^/*$ ```
which means that no analysis was found for the given inflectional form 


the split_l_elements.py file successfully solves this problem by correcting the  "bhojpuri-monodix_updated_with pardefs and sdefs.dix" file to  "bhojpuri-monodix-split.dix" which produces the correct output as following: 
```  echo adZaSaTano  | lt-proc  bhoj.automorf.bin ``` -->  ``` ^adZaSaTano/adZasaTa
<adj>
<pl>
<d>
<emph1>
$^/* ```

