package com.davidbharrison.restfun.num_to_english.service;

import com.davidbharrison.restfun.num_to_english.model.NumToEnglishResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@Service
public class NumToEnglishService {
    public static enum BIGGY {
        billion(1000000000), million(1000000), thousand(1000),
        hundred(100), ten(10);
        public final int divisor;

        private BIGGY(int divisor) {
            this.divisor = divisor;
        }

        public static NumToEnglishService.BIGGY getDivisor(int divisor) {
            return Arrays.asList(values())
                    .stream()
                    .filter(e -> e.divisor == divisor)
                    .findFirst()
                    .get();
        }
    }

    public static enum TENS {
        zero, ten, twenty, thirty,
        forty, fifty, sixty,
        seventy, eighty, ninety;

        public static TENS getById(int id) {
            return Arrays.asList(values())
                    .stream()
                    .filter(e -> e.ordinal() == id)
                    .findFirst()
                    .get();
        }
    }

    public static enum ONES {
        zero, one, two, three, four, five, six, seven, eight, nine;
        public static Optional<ONES> getById(int id) {
            return Arrays.asList(values())
                    .stream()
                    .filter(e -> e.ordinal() == id)
                    .findFirst();
        }
    }

    public static void recurse(StringBuilder sb, Integer num, String name) {
        if (num<0) {
            return;
        }
        if (num==0) {
            sb.append("zero");
            return;
        }
        if ((int)num/BIGGY.billion.divisor > 0) {
            recurse(sb, num/BIGGY.billion.divisor, BIGGY.billion.name());
            num %= BIGGY.billion.divisor;
        }
        if ((int)num/BIGGY.million.divisor > 0) {
            recurse(sb, num/BIGGY.million.divisor, BIGGY.million.name());
            num %= BIGGY.million.divisor;
        }
        if ((int)num/BIGGY.thousand.divisor > 0) {
            recurse(sb, num/BIGGY.thousand.divisor, BIGGY.thousand.name());
            num %= BIGGY.thousand.divisor;
        }
        if ((int)num/BIGGY.hundred.divisor > 0) {
            recurse(sb, num/BIGGY.hundred.divisor, BIGGY.hundred.name());
            num %= BIGGY.hundred.divisor;
        }
        if (num>0) {
            if (num<10) {
                if (sb.length()>0) sb.append(" ");
                sb.append(ONES.getById(num).get().name());
            }
            else if (num<20) {
                tenToNineteen(sb, num-10);
            }
            else {
                int tens = num/10;
                if (sb.length()>0) sb.append(" ");
                sb.append(TENS.getById(tens).name());
                if (num%10>0) {
                    if (sb.length()>0) sb.append(" ");
                    sb.append(ONES.getById(num%10).get().name());
                }
            }
            if (name!=null && name.length()>0) {
                sb.append(" ");
                sb.append(name);
            }
        }
    }
//
//    int newDivisor = divisor>1000
//                ? divisor/1000
//                : divisor==1000
//                    ? 100
//                    : divisor==10
//                        ? 1
//                        : 10;
//
//        recurse(sb, num%divisor, newDivisor);
//    }

    private static void tenToNineteen(StringBuilder sb, Integer tenSomething) {
        var res =
            switch(tenSomething) {
                case 0 -> "ten";
                case 1 -> "eleven";
                case 2 -> "twelve";
                case 3 -> "thirteen";
                case 4 -> "fourteen";
                case 5 -> "fifteen";
                case 6 -> "sixteen";
                case 7 -> "seventeen";
                case 8 -> "eighteen";
                case 9 -> "nineteen";
                default -> "";
            };
        if (res.length()>0) {
            if (sb.length()>0) sb.append(" ");
            sb.append(res);
        }
    }

    public NumToEnglishResponse converNumToEnglish(String req) {
        Integer num = Integer.valueOf(req);

        StringBuilder sb = new StringBuilder();

//        recurse(sb, num, BIGGY.billion.divisor);
        recurse(sb, num, null);
        String english = sb.toString();

        return NumToEnglishResponse.builder()
                .status("ok")
                .numInEnglish(english)
                .build();
    }
}
