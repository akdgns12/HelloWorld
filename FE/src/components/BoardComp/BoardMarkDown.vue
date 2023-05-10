<template>
    <div id="editor"></div>
</template>

<script>
    import Editor from '@toast-ui/editor';
    import '@toast-ui/editor/dist/toastui-editor.css';

    export default {
        data() {
            return {
                editor : null,
            }
        },
        mounted() {
            this.editor = new Editor({
                el : document.querySelector('#editor'),
                height : '25rem',
                width : '40rem',
                initialEditType : 'markdown',
                previewStyle: 'vertical'
            });
        }
    }


</script>