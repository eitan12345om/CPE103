for i in range(53):
   print "   @Test"
   print "   public void test%s_contains() {" % (i + 5)
   print "      TextToMorse txt = new TextToMorse();"
   print '      assertTrue(txt.getBST().contains(new CharacterOrder(MorseCode.get(%s))));' % (i + 1)
   print "   }\n"
