package com.hackhurricane.aashaconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.ImageTransformation;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class FamilyPlanning extends AppCompatActivity {
    TextView Description1;
    TextView Description2;
    TextView Description3;
    TextView Description4;
    TextView Description5;
    TextView Description6;

    ImageView Image11;
    ImageView Image12;
    ImageView Image21;
    ImageView Image22;
    ImageView Image31;
    ImageView Image32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_planning);

        Description1=findViewById(R.id.textView111);
        Description2=findViewById(R.id.textView121);
        Description3=findViewById(R.id.textView211);
        Description4=findViewById(R.id.textView221);
        Description5=findViewById(R.id.textView311);
        Description6=findViewById(R.id.textView321);

        Image11=findViewById(R.id.imageView11);
        Image12=findViewById(R.id.imageView12);
        Image21=findViewById(R.id.imageView21);
        Image22=findViewById(R.id.imageView22);
        Image31=findViewById(R.id.imageView31);
        Image32=findViewById(R.id.imageView32);

        String longText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam sagittis nisl nec ante convallis, eget bibendum nibh scelerisque. Morbi venenatis, nisi vitae eleifend bibendum, enim ex faucibus odio, in lacinia ipsum nisi euismod ipsum. Proin rhoncus efficitur ligula vel porttitor. Sed sagittis elementum massa, non finibus felis gravida non. Aliquam erat volutpat.";

        String longText1 = "Lactational Amenorrhea (LAM) protects from pregnancy for six months.";
        Description1.setText(longText1);
        makeTextViewResizable(Description1, 2, "See More", true);

        String longText2 = "Intra Uterine Contracaptive Device (IUCD) is a one time method and is effective upto 10 years.";
        Description2.setText(longText2);
        makeTextViewResizable(Description2, 2, "See More", true);

        String longText3 = "DMPA injection is given every three months and can even be used during breastfeeding.";
        Description3.setText(longText3);
        makeTextViewResizable(Description3, 2, "See More", true);

        String longText4 = "Oral Contracaptive Pills can be strated 6 months after delivery; one pill to be taken daily. Start immediately if not breastfeeding";
        Description4.setText(longText4);
        makeTextViewResizable(Description4, 2, "See More", true);

        String longText5 = "Spacing methods for males. It protects from pregnancy and sexually transmitted infection.";
        Description5.setText(longText5);
        makeTextViewResizable(Description5, 2, "See More", true);

        String longText6 = "Here we can add other methods of family planning that we will get to know and this is just a placeholder text.";
        Description6.setText(longText6);
        makeTextViewResizable(Description6, 2, "See More", true);

        Image11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DetailedInformationCetre.class);
                intent.putExtra("YTLink","The Lactational Amenorrhea Method (LAM) is a short-term family planning method based on the natural effect of breastfeeding on fertility. The act of exclusive breastfeeding suppresses the release of hormones that are necessary for ovulation. If certain conditions are met, the method provides protection from pregnancy for a woman immediately following birth until the child is six months old. LAM can also help increase optimal breastfeeding practices and good infant nutrition.\n" +
                        "Using LAM provides the couple time to decide on another modern method to use after LAM no longer offers effective protection from pregnancy. Counseling should include information about other methods and reinforce the need for a timely transition to another method.\n");
                startActivity(intent);
            }
        });

        Image12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DetailedInformationCetre.class);
                intent.putExtra("YTLink","An intrauterine device (IUD) is a type of birth control a healthcare provider inserts into your uterus. IUDs are the most commonly used type of long-acting reversible contraception (LARC). Once an IUD is inserted, you don’t have to worry about birth control until it’s time to replace it (three to 10 years, depending on the brand). LARCs, which include IUDs and contraceptive implants, are the most effective form of birth control that doesn’t require surgery.\n" +
                        "What are the advantages of using an IUD?\n" +
                        "IUDs:\n" +
                        "Have a 99% success rate.\n" +
                        "Prevent you from having to locate contraceptives before having sex.\n" +
                        "Are cost-effective and covered by Medicaid and most private insurers.\n" +
                        "Can be removed if you decide to become pregnant or switch birth control methods.\n" +
                        "Prevent you from getting pregnant for years without any ongoing maintenance on your part.\n" +
                        "Spare you the worry of having missed a birth control pill, forgotten to get a birth control shot, etc.\n");
                startActivity(intent);
            }
        });

        Image21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DetailedInformationCetre.class);
                intent.putExtra("YTLink","How does the contraceptive injection work?\n" +
                        "The progestogen is injected into a muscle or under the skin and then is gradually released into the bloodstream. It works mainly by stopping the release of the egg from the ovary (ovulation). It also thickens the mucus made by the neck of the womb (cervix) which forms a mucous plug. This stops sperm getting through to the womb (uterus) to fertilise an egg. It also makes the lining of the womb thinner. This makes it unlikely that any egg that has managed to be fertilised will be able to implant in the womb.\n" +
                        "What are the advantages of the contraceptive injection?\n" +
                        "You do not have to remember to take a pill every day. You only have to think about contraception every 2-3 months.\n" +
                        "It does not interfere with sex.\n" +
                        "It can be used when breastfeeding.\n" +
                        "Periods often stop completely, which is perfectly safe.\n" +
                        "It may help some of the problems of periods, such as premenstrual tension, heavy, painful periods and endometriosis.\n");
                startActivity(intent);
            }
        });

        Image22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DetailedInformationCetre.class);
                intent.putExtra("YTLink","The primary purpose of OCPs is to prevent pregnancy. However, some also help with:\n" +
                        "Endometriosis (painful condition in which uterine tissue grows outside the uterus) \n" +
                        "Heavy menstruation (bleeding)\n" +
                        "Heavy menstrual cramping\n" +
                        "Irregular menstruation\n" +
                        "Ovarian cysts\n" +
                        "Premenstrual dysphoric disorder (PMDD)\n" +
                        "Premenstrual syndrome (PMS)\n" +
                        "Side Effects\n" +
                        "The most common side effects are breakthrough bleeding or spotting, especially when first starting treatment. This is more common with progestin-only pills, but it can occur with combination pills.6 \n" +
                        "Other possible side effects of OCPs include:\n" +
                        "Acne\n" +
                        "Breast tenderness or enlargement\n" +
                        "Brown or black skin patches\n" +
                        "Change in appetite\n" +
                        "Gum tissue swelling\n" +
                        "Irritation or itching of the vagina\n" +
                        "Menstrual bleeding (period) changes\n" +
                        "Stomach upset\n" +
                        "Weight loss or gain\n" +
                        "White vaginal discharge\n" +
                        "Unusual hair growth\n" +
                        "While serious side effects from OCPs are uncommon, they often require medical attention. Talk to your healthcare provider if you experience any of the following:2\n" +
                        "Complete loss of appetite\n" +
                        "Coughing up blood\n" +
                        "Dark urine\n" +
                        "Fatigue\n" +
                        "Fever\n" +
                        "Heavy menstrual bleeding\n" +
                        "Leg pain\n" +
                        "Light-colored stool (poop)\n" +
                        "Rash\n" +
                        "Severe headache\n" +
                        "Severe vomiting\n" +
                        "Shortness of breath\n" +
                        "Swelling of legs, arms, hands, or ankles\n" +
                        "Vision or eye problems\n");
                startActivity(intent);
            }
        });

        Image31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DetailedInformationCetre.class);
                intent.putExtra("YTLink","When used properly, male condoms are about 98% effective at preventing pregnancy. This means that in one year, 2 out of every 100 women whose partners always use condoms correctly will get pregnant. That number rises to 18 out of every 100 women whose partners don’t use the condom correctly every time.\n" +
                        "Female condoms are about 95% effective when used properly. They work only 79% of the time if you don’t use them right.\n" +
                        "Still, condoms are very effective at preventing STDs like gonorrhea, chlamydia, herpes, and HIV(the virus that causes AIDS). The exact risk varies by the type of disease. For example, condoms are almost 100% effective at protecting against HIV. But HPV, the most common sexually transmitted disease, can infect areas that a male condom doesn’t cover, like the scrotum. Condoms lower the risk of HPV infection, but they don’t get rid of it.\n");
                startActivity(intent);
            }
        });

        Image32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DetailedInformationCetre.class);
                intent.putExtra("YTLink","Twoj52flJ9s");
                startActivity(intent);
            }
        });

//        String truncatedText = originalText.substring(0, 50); // Replace 50 with the desired maximum length of the truncated text.
//
//        SpannableString spannableString = new SpannableString(truncatedText + " Read More");
//        ClickableSpan clickableSpan = new ClickableSpan() {
//            @Override
//            public void onClick(View view) {
//                textView.setText(originalText);
//            }
//        };
//        spannableString.setSpan(clickableSpan, truncatedText.length() + 1, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        textView.setText(spannableString);
//        textView.setMovementMethod(LinkMovementMethod.getInstance());


        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.info);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            // Define the mapping of menu item IDs to corresponding activities
            Map<Integer, Class<?>> activityMap = new HashMap<>();
            activityMap.put(R.id.info, Info.class);
            activityMap.put(R.id.home, MainActivity.class);
            activityMap.put(R.id.profile, profile.class);

            // Check if the selected item is present in the activityMap
            Class<?> destinationActivity = activityMap.get(item.getItemId());
            if (destinationActivity != null) {
                // Start the corresponding activity
                startActivity(new Intent(getApplicationContext(), destinationActivity));
                overridePendingTransition(0, 0);
                return true;
            }
            return false;
        });
    }

    public static void makeTextViewResizable(final TextView tv, final int maxLine, final String expandText, final boolean viewMore) {

        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {

                ViewTreeObserver obs = tv.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
                if (maxLine == 0) {
                    int lineEndIndex = tv.getLayout().getLineEnd(0);
                    String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, maxLine, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                    int lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                    String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, maxLine, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                } else {
                    int lineEndIndex = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                    String text = tv.getText().subSequence(0, lineEndIndex) + " " + expandText;
                    tv.setText(text);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    tv.setText(
                            addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, lineEndIndex, expandText,
                                    viewMore), TextView.BufferType.SPANNABLE);
                }
            }
        });

    }

    private static SpannableStringBuilder addClickablePartTextViewResizable(final Spanned strSpanned, final TextView tv,
                                                                            final int maxLine, final String spanableText, final boolean viewMore) {
        String str = strSpanned.toString();
        SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);

        if (str.contains(spanableText)) {


            ssb.setSpan(new MySpannable(false){
                @Override
                public void onClick(View widget) {
                    if (viewMore) {
                        tv.setLayoutParams(tv.getLayoutParams());
                        tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        makeTextViewResizable(tv, -1, "See Less", false);
                    } else {
                        tv.setLayoutParams(tv.getLayoutParams());
                        tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        makeTextViewResizable(tv, 3, ".. See More", true);
                    }
                }
            }, str.indexOf(spanableText), str.indexOf(spanableText) + spanableText.length(), 0);

        }
        return ssb;

    }
}