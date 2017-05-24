public class YepServer implements YepProtocol {

    public String processInput(String message) {

        String replyText = YepProtocol.Vocabulary.NEGATIVE.getTag();

        if (!message.isEmpty()) {

            String msgTag = message.substring(0, 3);
            String msgText = message.substring(4);
            replyText += ":" + msgText;

            if (msgTag.equals(YepProtocol.Vocabulary.MESSAGE.getTag()) &&
                    (message.charAt(3) == ':') &&
                    (msgText.length() <= VALID_MSG_LENGTH)) {

                replyText = YepProtocol.Vocabulary.ACKNOWLEDGMENT.getTag() + ":" + msgText;
            }
        }

        return replyText;

    }

}