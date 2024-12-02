package btvnbuoi4;

public class Bai1 {
    public static void main(String[] args) {
        String paragraph = "Ngôn ngữ lập trình Java ban đầu được phát triển bởi Sun Microsystems do James Gosling khởi xướng và phát hành vào năm 1995. Phiên bản mới nhất của Java Standard Edition là Java SE 8. Với sự tiến bộ của Java và sự phổ biến rộng rãi của nó, nhiều cấu hình đã được xây dựng để phù hợp với nhiều loại nền tảng khác nhau. Ví dụ: J2EE cho các ứng dụng doanh nghiệp, J2ME cho các ứng dụng di động.";
        String[] words = paragraph.toLowerCase().replaceAll( "[^\\p{L}\\s]", "").split(" ");
        countWord(words);
        removeVowel(paragraph);
    }
    public static String capitalize(String word) {
        return word.toUpperCase().charAt(0) + word.substring(1);
    }
    public static void countWord(String[] words) {
        String[] words2 = words.clone() ;
        System.out.println("Đếm số lượng từng từ trong đoạn:");
        for (int i = 0; i < words2.length; i++) {
            if (!("".equals(words2[i]))) {
                int count = 1;
                for (int j = 1; j < words2.length; j++) {
                    if (i != j && words2[i].equals(words2[j])) {
                        count++;
                        words2[j] = "";
                    }
                }
                System.out.printf("%s: %d từ\n", capitalize(words2[i]), count);
            }
        }
    }
    public static void removeVowel(String paragraph) {
        System.out.println("Chuỗi sau khi bỏ nguyên âm:\n " + paragraph.replaceAll("[aáàảãạăắằẳẵặâấầẩẫậeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵ]", ""));
    }
}
