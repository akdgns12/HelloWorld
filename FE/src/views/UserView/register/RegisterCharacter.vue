<template>
    <div class="logos">
        <div class="logo">
            <router-link to="/"><img class="logo-img" src="../../../assets/image/Logo.png" alt="logo" /></router-link>
        </div>
        <div class="person">
            <router-link to="/"><img class="person-img" src="../../../assets/image/Person.png" alt="logo" /></router-link>
        </div>
    </div>
    <div class="my-character-container" style="position: relative;">
        <img class="my-character-img" src="../../../assets/image/BasicAvatar.png" alt="내 아바타" />
        <div class="my-character-img" style="position: absolute; top: -2.5px; left: 0px; z-index: 100;">
            <img class="my-character-hair" id="hair" :src="hairSrc" v-if="hairSrc" />
        </div>
        <div class="my-character-img" style="position: absolute; top: 40px; left: 5px; z-index: 100; transform: scale(1.5)">
            <img class="my-character-pet" id="pet" :src="petSrc" v-if="petSrc" />
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
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-1.png"
                                    @click="changeHair" id="1"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-2.png" @click="changeHair" id="2"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-3.png" @click="changeHair" id="3"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-4.png" @click="changeHair" id="4"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-5.png" @click="changeHair" id="5"/>
                            </div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-6.png" @click="changeHair" id="6"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-7.png" @click="changeHair" id="7"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-8.png" @click="changeHair" id="8"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-9.png" @click="changeHair" id="9"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-10.png" @click="changeHair" id="10"/>
                            </div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-11.png" @click="changeHair" id="11"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-12.png" @click="changeHair" id="12"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-13.png" @click="changeHair" id="13"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-14.png" @click="changeHair" id="14"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-15.png" @click="changeHair" id="15"/>
                            </div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-16.png" @click="changeHair" id="16"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-17.png" @click="changeHair" id="17"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-18.png" @click="changeHair" id="18"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-19.png" @click="changeHair" id="19"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-20.png" @click="changeHair" id="20"/>
                            </div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-21.png" @click="changeHair" id="21"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-22.png" @click="changeHair" id="22"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-23.png" @click="changeHair" id="23"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-24.png" @click="changeHair" id="24"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-25.png" @click="changeHair" id="25"/>
                            </div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-26.png" @click="changeHair" id="26"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-27.png" @click="changeHair" id="27"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-28.png" @click="changeHair" id="28"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-29.png" @click="changeHair" id="29"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-30.png" @click="changeHair" id="30"/>
                            </div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-31.png" @click="changeHair" id="31"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-32.png" @click="changeHair" id="32"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-33.png" @click="changeHair" id="33"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-34.png" @click="changeHair" id="34"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-35.png" @click="changeHair" id="35"/>
                            </div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-36.png" @click="changeHair" id="36"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-37.png" @click="changeHair" id="37"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-38.png" @click="changeHair" id="38"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-39.png" @click="changeHair" id="39"/>
                            </div>
                            <div class="hair-element-container">
                                <img class="hair-element" alt="헤어" src="@/assets/image/hair/pixil-layer-40.png" @click="changeHair" id="40"/>
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
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-1.png"
                                    @click="changePet" id="1"/>
                            </div>
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-2.png"
                                    @click="changePet" id="2"/>
                            </div>
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-3.png"
                                    @click="changePet" id="3"/>
                            </div>
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-4.png"
                                    @click="changePet" id="4"/>
                            </div>
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-5.png"
                                    @click="changePet" id="5"/>
                            </div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-6.png"
                                    @click="changePet" id="6"/>
                            </div>
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-7.png"
                                    @click="changePet" id="7"/>
                            </div>
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-8.png"
                                    @click="changePet" id="8"/>
                            </div>
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-9.png"
                                    @click="changePet" id="9"/>
                            </div>
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-10.png"
                                    @click="changePet" id="10"/>
                            </div>
                        </div>
                    </splide-slide>
                    <splide-slide class="splide-slide">
                        <div class="one-slide">
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-11.png"
                                    @click="changePet" id="11"/>
                            </div>
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-12.png"
                                    @click="changePet" id="12"/>
                            </div>
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-13.png"
                                    @click="changePet" id="13"/>
                            </div>
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-14.png"
                                    @click="changePet" id="14"/>
                            </div>
                            <div class="pet-element-container">
                                <img class="pet-element" alt="펫" src="@/assets/image/pet/pixil-layer-15.png"
                                    @click="changePet" id="15"/>
                            </div>
                        </div>
                    </splide-slide>
                </splide>
            </div>
        </div>
    </div>
    <div class="button-group">
        <button class="cancel-btn" @click="this.$router.push({ path: '/join' })">이전</button>
        <button class="next-btn" @click="this.$router.push({ path: '/' })">완료</button>
    </div>
</template>

<script>
import { Splide, SplideSlide } from '@splidejs/vue-splide';
// Default theme
import '@splidejs/vue-splide/css';
export default {
    name: 'RegisterCharacter',
    component:
    {
        Splide,
        SplideSlide,
    }
    ,
    data() {
        return {
            options: {
                type: 'loop',
                rewind: true,
                perPage: 1,
                autoplay: false,
                pauseOnHover: false,
                arrows: true,
                dots: false,
                animatedDots: false,
                speed: 800,
                fixedWidth: '100%',
                padding: 10,
                pagination: false,
            },
            hairSrc: null,
            petSrc: null,
        };
    },
    methods: {
        changeHair: function(e) {
            e.preventDefault();
            var path=require("@/assets/image/hair/pixil-layer-"+e.target.id+".png");
            this.hairSrc=path;
        },
        changePet: function(e) {
            e.preventDefault();
            var path=require("@/assets/image/pet/pixil-layer-"+e.target.id+".png");
            this.petSrc=path;
        }
    }

}
</script>

<style scoped>
a {
    text-decoration: none;
    color: white;
}

.splide-slide {
    display: flex;
    height: 50px;
}

.one-slide {
    margin: 0 auto;
    display: flex;
    justify-content: space-evenly;
}

.hair-element-container {
    width: 80px;
    height: 45px;
    border: 1px solid #D9D9D9;
    border-radius: 5px;
    margin-left: 1px;
    margin-right: 1px;
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
    width: 80px;
    height: 45px;
    border: 1px solid #D9D9D9;
    border-radius: 5px;
    margin-left: 1px;
    margin-right: 1px;
    margin-bottom: 5%;
    cursor: pointer;
}

.pet-element {
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
    border: 1px solid #6A6A6A;
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

.my-chacracter-pet {
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
    color: #82ACC1;
    font-size: 13px;
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
    color: #82ACC1;
    font-size: 13px;
    font-weight: 600;
    margin-bottom: 5px;
}

.select-pet {
    width: 90%;
}

.button-group {
    display: flex;
    justify-content: space-between;
    margin: 0 auto;
    margin-top: 63px;
    width: 30%;
}

.cancel-btn {
    width: 49%;
    padding-top: 6px;
    padding-bottom: 6px;
    background-color: #D24646;
    opacity: 78%;
    border: none;
    border-radius: 4px;
    color: white;
    font-weight: 500;
    cursor: pointer;
    text-decoration: none;
}

.next-btn {
    width: 49%;
    padding-top: 6px;
    padding-bottom: 6px;
    background-color: #82ACC1;
    border: none;
    border-radius: 4px;
    color: white;
    font-weight: 500;
    cursor: pointer;
}
</style>