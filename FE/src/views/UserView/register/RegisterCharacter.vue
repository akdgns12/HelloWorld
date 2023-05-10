<template>
  <div class="logos">
    <div class="logo">
      <router-link to="/"
        ><img class="logo-img" src="../../../assets/image/Logo.png" alt="logo"
      /></router-link>
    </div>
    <div class="person">
      <router-link to="/"
        ><img
          class="person-img"
          src="../../../assets/image/Person.png"
          alt="logo"
      /></router-link>
    </div>
  </div>
  <div
    class="my-character-container"
    id="my-character-container"
    style="position: relative"
  >
    <img
      class="my-character-img"
      src="../../../assets/image/BasicAvatar.png"
      alt="내 아바타"
    />
    <div
      class="my-character-img"
      style="position: absolute; top: -2.5px; left: 0px; z-index: 100"
    >
      <img class="my-character-hair" id="hair" :src="hairSrc" v-if="hairSrc" />
    </div>
    <div
      class="my-character-img"
      style="position: absolute; top: -2.5px; left: 0px; z-index: 100"
    >
      <img class="my-character-pet" id="pet" :src="petSrc" v-if="petSrc" />
    </div>
    <div
      class="my-character-img"
      style="position: absolute; top: -2.5px; left: 0px; z-index: 100"
    >
      <img
        class="my-character-emotion"
        id="emotion"
        :src="emotionSrc"
        v-if="emotionSrc"
      />
    </div>
    <div
      class="my-character-img"
      style="position: absolute; top: -2.5px; left: 0px; z-index: 100"
    >
      <img
        class="my-character-shirt"
        id="shirt"
        :src="shirtSrc"
        v-if="shirtSrc"
      />
    </div>
    <div
      class="my-character-img"
      style="position: absolute; top: -2.5px; left: 0px; z-index: 100"
    >
      <img
        class="my-character-pants"
        id="pants"
        :src="pantsSrc"
        v-if="pantsSrc"
      />
    </div>
  </div>
  <div class="wrap">
    <div class="hair-container">
      <div class="hair">헤어</div>
      <div class="select-hair">
        <splide :options="options" class="slider">
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-1.png"
                  @click="changeHair"
                  id="1"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-2.png"
                  @click="changeHair"
                  id="2"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-3.png"
                  @click="changeHair"
                  id="3"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-4.png"
                  @click="changeHair"
                  id="4"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-5.png"
                  @click="changeHair"
                  id="5"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-6.png"
                  @click="changeHair"
                  id="6"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-7.png"
                  @click="changeHair"
                  id="7"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-8.png"
                  @click="changeHair"
                  id="8"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-9.png"
                  @click="changeHair"
                  id="9"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-10.png"
                  @click="changeHair"
                  id="10"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-11.png"
                  @click="changeHair"
                  id="11"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-12.png"
                  @click="changeHair"
                  id="12"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-13.png"
                  @click="changeHair"
                  id="13"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-14.png"
                  @click="changeHair"
                  id="14"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-15.png"
                  @click="changeHair"
                  id="15"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-16.png"
                  @click="changeHair"
                  id="16"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-17.png"
                  @click="changeHair"
                  id="17"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-18.png"
                  @click="changeHair"
                  id="18"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-19.png"
                  @click="changeHair"
                  id="19"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-20.png"
                  @click="changeHair"
                  id="20"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-21.png"
                  @click="changeHair"
                  id="21"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-22.png"
                  @click="changeHair"
                  id="22"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-23.png"
                  @click="changeHair"
                  id="23"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-24.png"
                  @click="changeHair"
                  id="24"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-25.png"
                  @click="changeHair"
                  id="25"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-26.png"
                  @click="changeHair"
                  id="26"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-27.png"
                  @click="changeHair"
                  id="27"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-28.png"
                  @click="changeHair"
                  id="28"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-29.png"
                  @click="changeHair"
                  id="29"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-30.png"
                  @click="changeHair"
                  id="30"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-31.png"
                  @click="changeHair"
                  id="31"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-32.png"
                  @click="changeHair"
                  id="32"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-33.png"
                  @click="changeHair"
                  id="33"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-34.png"
                  @click="changeHair"
                  id="34"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-35.png"
                  @click="changeHair"
                  id="35"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-36.png"
                  @click="changeHair"
                  id="36"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-37.png"
                  @click="changeHair"
                  id="37"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-38.png"
                  @click="changeHair"
                  id="38"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-39.png"
                  @click="changeHair"
                  id="39"
                />
              </div>
              <div class="hair-element-container">
                <img
                  class="hair-element"
                  alt="헤어"
                  src="@/assets/image/hair/pixil-layer-40.png"
                  @click="changeHair"
                  id="40"
                />
              </div>
            </div>
          </splide-slide>
        </splide>
      </div>
    </div>
    <div class="pet-container">
      <div class="pet">펫</div>
      <div class="select-pet">
        <splide :options="options" class="slider">
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-1.png"
                  @click="changePet"
                  id="1"
                />
              </div>
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-2.png"
                  @click="changePet"
                  id="2"
                />
              </div>
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-3.png"
                  @click="changePet"
                  id="3"
                />
              </div>
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-4.png"
                  @click="changePet"
                  id="4"
                />
              </div>
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-5.png"
                  @click="changePet"
                  id="5"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-6.png"
                  @click="changePet"
                  id="6"
                />
              </div>
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-7.png"
                  @click="changePet"
                  id="7"
                />
              </div>
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-8.png"
                  @click="changePet"
                  id="8"
                />
              </div>
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-9.png"
                  @click="changePet"
                  id="9"
                />
              </div>
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-10.png"
                  @click="changePet"
                  id="10"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-11.png"
                  @click="changePet"
                  id="11"
                />
              </div>
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-12.png"
                  @click="changePet"
                  id="12"
                />
              </div>
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-13.png"
                  @click="changePet"
                  id="13"
                />
              </div>
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-14.png"
                  @click="changePet"
                  id="14"
                />
              </div>
              <div class="pet-element-container">
                <img
                  class="pet-element"
                  alt="펫"
                  src="@/assets/image/pet/pixil-layer-15.png"
                  @click="changePet"
                  id="15"
                />
              </div>
            </div>
          </splide-slide>
        </splide>
      </div>
    </div>
    <div class="emotion-container">
      <div class="emotion">감정표현</div>
      <div class="select-emotion">
        <splide :options="options" class="slider">
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-1.png"
                  @click="changeEmotion"
                  id="1"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-2.png"
                  @click="changeEmotion"
                  id="2"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-3.png"
                  @click="changeEmotion"
                  id="3"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-4.png"
                  @click="changeEmotion"
                  id="4"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-5.png"
                  @click="changeEmotion"
                  id="5"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-6.png"
                  @click="changeEmotion"
                  id="6"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-7.png"
                  @click="changeEmotion"
                  id="7"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-8.png"
                  @click="changeEmotion"
                  id="8"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-9.png"
                  @click="changeEmotion"
                  id="9"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-10.png"
                  @click="changeEmotion"
                  id="10"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-11.png"
                  @click="changeEmotion"
                  id="11"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-12.png"
                  @click="changeEmotion"
                  id="12"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-13.png"
                  @click="changeEmotion"
                  id="13"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-14.png"
                  @click="changeEmotion"
                  id="14"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-15.png"
                  @click="changeEmotion"
                  id="15"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-16.png"
                  @click="changeEmotion"
                  id="16"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-17.png"
                  @click="changeEmotion"
                  id="17"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-18.png"
                  @click="changeEmotion"
                  id="18"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-19.png"
                  @click="changeEmotion"
                  id="19"
                />
              </div>
              <div class="emotion-element-container">
                <img
                  class="emotion-element"
                  alt="감정표현"
                  src="@/assets/image/emotion/pixil-layer-20.png"
                  @click="changeEmotion"
                  id="20"
                />
              </div>
            </div>
          </splide-slide>
        </splide>
      </div>
    </div>
    <div class="shirt-container">
      <div class="shirt">상의</div>
      <div class="select-shirt">
        <splide :options="options" class="slider">
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-1.png"
                  @click="changeShirt"
                  id="1"
                />
              </div>
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-2.png"
                  @click="changeShirt"
                  id="2"
                />
              </div>
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-3.png"
                  @click="changeShirt"
                  id="3"
                />
              </div>
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-4.png"
                  @click="changeShirt"
                  id="4"
                />
              </div>
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-5.png"
                  @click="changeShirt"
                  id="5"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-6.png"
                  @click="changeShirt"
                  id="6"
                />
              </div>
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-7.png"
                  @click="changeShirt"
                  id="7"
                />
              </div>
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-8.png"
                  @click="changeShirt"
                  id="8"
                />
              </div>
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-9.png"
                  @click="changeShirt"
                  id="9"
                />
              </div>
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-10.png"
                  @click="changeShirt"
                  id="10"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-11.png"
                  @click="changeShirt"
                  id="11"
                />
              </div>
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-12.png"
                  @click="changeShirt"
                  id="12"
                />
              </div>
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-13.png"
                  @click="changeShirt"
                  id="13"
                />
              </div>
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-14.png"
                  @click="changeShirt"
                  id="14"
                />
              </div>
              <div class="shirt-element-container">
                <img
                  class="shirt-element"
                  alt="상의"
                  src="@/assets/image/shirt/pixil-layer-15.png"
                  @click="changeShirt"
                  id="15"
                />
              </div>
            </div>
          </splide-slide>
        </splide>
      </div>
    </div>
    <div class="pants-container">
      <div class="pants">하의</div>
      <div class="select-pants">
        <splide :options="options" class="slider">
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-1.png"
                  @click="changePants"
                  id="1"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-2.png"
                  @click="changePants"
                  id="2"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-3.png"
                  @click="changePants"
                  id="3"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-4.png"
                  @click="changePants"
                  id="4"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-5.png"
                  @click="changePants"
                  id="5"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-6.png"
                  @click="changePants"
                  id="6"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-7.png"
                  @click="changePants"
                  id="7"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-8.png"
                  @click="changePants"
                  id="8"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-9.png"
                  @click="changePants"
                  id="9"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-10.png"
                  @click="changePants"
                  id="10"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-11.png"
                  @click="changePants"
                  id="11"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-12.png"
                  @click="changePants"
                  id="12"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-13.png"
                  @click="changePants"
                  id="13"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-14.png"
                  @click="changePants"
                  id="14"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-15.png"
                  @click="changePants"
                  id="15"
                />
              </div>
            </div>
          </splide-slide>
          <splide-slide class="splide-slide">
            <div class="one-slide">
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-16.png"
                  @click="changePants"
                  id="16"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-17.png"
                  @click="changePants"
                  id="17"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-18.png"
                  @click="changePants"
                  id="18"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-19.png"
                  @click="changePants"
                  id="19"
                />
              </div>
              <div class="pants-element-container">
                <img
                  class="pants-element"
                  alt="하의"
                  src="@/assets/image/pants/pixil-layer-20.png"
                  @click="changePants"
                  id="20"
                />
              </div>
            </div>
          </splide-slide>
        </splide>
      </div>
    </div>
  </div>
  <div class="button-group">
    <button class="cancel-btn" @click="this.$router.push({ path: '/join' })">
      이전
    </button>
    <button class="next-btn" @click="join">완료</button>
  </div>
</template>

<script>
import { Splide, SplideSlide } from "@splidejs/vue-splide";
import html2canvas from "html2canvas";
// import http from '@/api/http';
import axios from "axios";
// Default theme
import "@splidejs/vue-splide/css";
export default {
  name: "RegisterCharacter",
  props: ["email", "password", "userName", "nickname", "phonenum"],
  component: {
    Splide,
    SplideSlide,
  },
  data() {
    return {
      options: {
        type: "loop",
        rewind: true,
        perPage: 1,
        autoplay: false,
        pauseOnHover: false,
        arrows: true,
        dots: false,
        animatedDots: false,
        speed: 800,
        fixedWidth: "100%",
        padding: 10,
        pagination: false,
      },
      hairSrc: null,
      petSrc: null,
      emotionSrc: null,
      shirtSrc: null,
      pantsSrc: null,
    };
  },
  methods: {
    changeHair: function (e) {
      e.preventDefault();
      var path = require("@/assets/image/hair/pixil-layer-" +
        e.target.id +
        ".png");
      if (this.hairSrc == path) {
        this.hairSrc = null;
      } else {
        this.hairSrc = path;
      }
    },
    changePet: function (e) {
      e.preventDefault();
      var path = require("@/assets/image/pet/pixil-layer-" +
        e.target.id +
        ".png");
      if (this.petSrc == path) {
        this.petSrc = null;
      } else {
        this.petSrc = path;
      }
    },
    changeEmotion: function (e) {
      e.preventDefault();
      var path = require("@/assets/image/emotion/pixil-layer-" +
        e.target.id +
        ".png");
      if (this.emotionSrc == path) {
        this.emotionSrc = null;
      } else {
        this.emotionSrc = path;
      }
    },
    changeShirt: function (e) {
      e.preventDefault();
      var path = require("@/assets/image/shirt/pixil-layer-" +
        e.target.id +
        ".png");
      if (this.shirtSrc == path) {
        this.shirtSrc = null;
      } else {
        this.shirtSrc = path;
      }
    },
    changePants: function (e) {
      e.preventDefault();
      var path = require("@/assets/image/pants/pixil-layer-" +
        e.target.id +
        ".png");
      if (this.pantsSrc == path) {
        this.pantsSrc = null;
      } else {
        this.pantsSrc = path;
      }
    },
    join: async function () {
      var userAvatar;
      var file;
      var realFile;
      await html2canvas(document.querySelector("#my-character-container")).then(
        function (canvas) {
          userAvatar = canvas.toDataURL("image/png");
          var blobBin = atob(userAvatar.split(",")[1]); // base64 데이터 디코딩
          var array = [];
          for (var i = 0; i < blobBin.length; i++) {
            array.push(blobBin.charCodeAt(i));
          }
          file = new Blob([new Uint8Array(array)], { type: "image/png" });
          // userAvatar = userAvatar.replace("data:image/png;base64,", "");
        }
      );
      //   var user = {
      //     email: this.email,
      //     name: this.userName,
      //     nickname: this.nickname,
      //     password: this.password,
      //     phoneNumber: this.phonenum,
      //   };
      var formData = new FormData();

      //   formData.append("user", JSON.stringify(user));
      formData.append("email", this.email);
      formData.append("name", this.userName);
      formData.append("nickname", this.nickname);
      formData.append("password", this.password);
      formData.append("phoneNumber", this.phonenum);
      realFile = new File([file], `${this.email}_avatar.png`);
      formData.append("img", realFile);
      // console.log(user);
      // http.post(`/user/signUp`, JSON.stringify(user)).then(
      //     (response)=> {
      //         console.log(response);
      //         this.$router.push({name: 'login'});
      //     },
      //     (error)=> {
      //         console.log(error);
      //     }
      // )
      axios
        .post(`https://k8a308.p.ssafy.io/api/user/signUp`, formData, {
          headers: { "Content-Type": "multipart/form-data" },
        })
        .then(
          (response) => {
            console.log(response);
            this.$router.push({ name: "login" });
          },
          (error) => {
            console.log(error);
          }
        );
    },
  },
};
</script>

<style scoped>
a {
  text-decoration: none;
  color: white;
}

.splide-slide {
  display: flex;
  height: 90px;
}

.one-slide {
  margin: 0 auto;
  display: flex;
  justify-content: space-evenly;
  width: 98%;
}

.hair-element-container {
  width: 100px;
  height: 80px;
  border: 1px solid #d9d9d9;
  border-radius: 5px;
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 5%;
  cursor: pointer;
}

.hair-element {
  width: 100%;
  height: 100%;
  object-fit: fill;
  transform: scale(1.2);
}

.pet-element-container {
  width: 100px;
  height: 80px;
  border: 1px solid #d9d9d9;
  border-radius: 5px;
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 5%;
  cursor: pointer;
}

.pet-element {
  width: 100%;
  height: 100%;
  object-fit: fill;
  transform: scale(1.2);
}

.emotion-element-container {
  width: 100px;
  height: 80px;
  border: 1px solid #d9d9d9;
  border-radius: 5px;
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 5%;
  cursor: pointer;
}

.emotion-element {
  width: 100%;
  height: 100%;
  object-fit: fill;
  transform: scale(1.2);
}

.shirt-element-container {
  width: 100px;
  height: 80px;
  border: 1px solid #d9d9d9;
  border-radius: 5px;
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 5%;
  cursor: pointer;
}

.shirt-element {
  width: 100%;
  height: 100%;
  object-fit: fill;
  transform: scale(1.2);
}

.pants-element-container {
  width: 100px;
  height: 80px;
  border: 1px solid #d9d9d9;
  border-radius: 5px;
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 5%;
  cursor: pointer;
}

.pants-element {
  width: 100%;
  height: 100%;
  object-fit: fill;
  transform: scale(1.2);
}

.wrap {
  position: absolute;
  top: 5%;
  left: 35%;
  width: 62%;
  text-align: start;
}

.slider {
  width: 100%;
  margin: 0 auto;
}

.my-character-container {
  margin-left: 10%;
  margin-top: 15%;
  width: 15%;
  height: 15%;
  border: 1px solid #d9d9d9;
  border-radius: 20px;
}

.my-character-img {
  width: 100%;
  height: 100%;
  object-fit: fill;
}

.my-character-hair {
  width: 100%;
  height: 100%;
  object-fit: fill;
}

.my-character-pet {
  width: 100%;
  height: 100%;
  object-fit: fill;
}

.my-character-emotion {
  width: 100%;
  height: 100%;
  object-fit: fill;
}

.my-character-shirt {
  width: 100%;
  height: 100%;
  object-fit: fill;
}

.my-character-pants {
  width: 100%;
  height: 100%;
  object-fit: fill;
}

.logos {
  display: flex;
  position: absolute;
  top: 5%;
  left: 10%;
  width: 15%;
}

.logo {
  width: 80%;
  height: 140%;
}

.logo-img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.person {
  width: 45%;
  height: 100%;
}

.person-img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.hair-container {
  width: 90%;
  margin-bottom: 12px;
}

.hair {
  color: #82acc1;
  font-size: 15px;
  font-weight: 600;
  margin-bottom: 5px;
}

.select-hair {
  width: 90%;
}

.pet-container {
  width: 90%;
  margin-bottom: 12px;
}

.pet {
  color: #82acc1;
  font-size: 15px;
  font-weight: 600;
  margin-bottom: 5px;
}

.select-pet {
  width: 90%;
}

.select-emotion {
  width: 90%;
}

.emotion-container {
  width: 90%;
  margin-bottom: 12px;
}

.emotion {
  color: #82acc1;
  font-size: 15px;
  font-weight: 600;
  margin-bottom: 5px;
}

.select-shirt {
  width: 90%;
}

.shirt-container {
  width: 90%;
  margin-bottom: 12px;
}

.shirt {
  color: #82acc1;
  font-size: 15px;
  font-weight: 600;
  margin-bottom: 5px;
}

.select-pants {
  width: 90%;
}

.pants-container {
  width: 90%;
  margin-bottom: 12px;
}

.pants {
  color: #82acc1;
  font-size: 15px;
  font-weight: 600;
  margin-bottom: 5px;
}

.button-group {
  display: flex;
  justify-content: space-between;
  margin: 0 auto;
  margin-top: 220px;
  width: 30%;
}

.cancel-btn {
  width: 49%;
  padding-top: 10px;
  padding-bottom: 10px;
  background-color: #d24646;
  opacity: 78%;
  border: none;
  border-radius: 4px;
  color: white;
  font-weight: 500;
  cursor: pointer;
  text-decoration: none;
  font-size: 15px;
}

.cancel-btn:hover {
  transform: scale(1.05);
  transition: 0.5s;
}

.next-btn {
  width: 49%;
  padding-top: 10px;
  padding-bottom: 10px;
  background-color: #82acc1;
  border: none;
  border-radius: 4px;
  color: white;
  font-weight: 500;
  cursor: pointer;
  font-size: 15px;
}

.next-btn:hover {
  transform: scale(1.05);
  transition: 0.5s;
}
</style>
