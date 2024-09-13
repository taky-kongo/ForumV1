package ci.digitalacademy.ForumV1.utils;

import com.github.slugify.Slugify;

import java.util.UUID;

public final class SlugifyUtils {

    private SlugifyUtils() {}

    public static String generateSlugify(String text) {
        String value = String.format("%s %s", text, UUID.randomUUID());
        final Slugify slg =Slugify.builder().underscoreSeparator(true).build();
        return slg.slugify(value);
    }
}
